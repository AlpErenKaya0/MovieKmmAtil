package com.alperen.moviekmmatil.android.home

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alperen.moviekmmatil.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    val getMoviesUseCase: GetMoviesUseCase
): ViewModel() {
    var uiState by mutableStateOf(HomeScreenState())
    private var currentPage = 1
    init {
        loadMovies(forceReload = false)
    }

    fun loadMovies(forceReload: Boolean = false) {
    if(uiState.loading) return
        //eğer bunun gibi çok basit bir şey yazacaksak if(uiState.loading) { return }
        //gibi süslü parantez kullanmaya gerek yok
    if(forceReload) {
        currentPage = 1
    }
        if (currentPage == 1 ) {
            uiState = uiState.copy(refreshing = true)
        }
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)
            try {
                val resultMovies = getMoviesUseCase(page = currentPage)


                val movies = if ( currentPage ==1 ) resultMovies else uiState.movies + resultMovies
                //alttaki yapı yerine basitçe yukarıdaki gibi yazabiliriz
                /*
                if (currentPage != 1){
                    val movies = uiState.movies +resultMovies
                } else {
                    val movies = resultMovies
                }
                 */
                currentPage += 1
                uiState = uiState.copy(
                    loading= false,
                    refreshing = false,
                    loadFinished = resultMovies.isEmpty(),
                    movies = movies
                )
            } catch (error:Throwable) {
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = true,
                    errorMessage = "Could not load: ${error.localizedMessage}"
                )
            }
        }
    }
}