package com.alperen.moviekmmatil.data.repository

import com.alperen.moviekmmatil.data.remote.RemoteDataSource
import com.alperen.moviekmmatil.data.util.toMovie
import com.alperen.moviekmmatil.domain.model.Movie
import com.alperen.moviekmmatil.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
return remoteDataSource.getMovies(page = page).results.map {
    it.toMovie()
}
    }
    override suspend fun getMovie(movieId: Int): Movie {
return remoteDataSource.getMovie(movieId = movieId).toMovie()
    }
}