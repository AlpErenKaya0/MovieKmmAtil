package com.alperen.moviekmmatil.di

import com.alperen.moviekmmatil.data.remote.MovieService
import com.alperen.moviekmmatil.data.remote.RemoteDataSource
import com.alperen.moviekmmatil.data.repository.MovieRepositoryImpl
import com.alperen.moviekmmatil.domain.repository.MovieRepository
import com.alperen.moviekmmatil.domain.usecase.GetMovieUseCase
import com.alperen.moviekmmatil.domain.usecase.GetMoviesUseCase
import com.alperen.moviekmmatil.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    //single yaparsan da çalışır ama factory kullanman önerilir
    factory { RemoteDataSource(get(),get())}
    factory { MovieService()}
}
private val utilModule = module {
    factory{ provideDispatcher() }
}
private val domainModule = module {
    factory { GetMovieUseCase()}
    factory { GetMoviesUseCase() }
    single<MovieRepository> {MovieRepositoryImpl(get())}
}
private val sharedModules = listOf(dataModule, utilModule, domainModule)
fun getSharedModules() = sharedModules