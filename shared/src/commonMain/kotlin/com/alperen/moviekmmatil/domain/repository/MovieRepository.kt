package com.alperen.moviekmmatil.domain.repository

import com.alperen.moviekmmatil.domain.model.Movie

internal interface MovieRepository {
    suspend fun getMovies(page: Int) : List<Movie>
    suspend fun getMovie(movieId: Int) : Movie
}