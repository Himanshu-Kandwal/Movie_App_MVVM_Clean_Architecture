package com.movieappmvvmcleanarchitecture.data.repository.movie.datasource

import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.model.movie.MovieList
import retrofit2.Response


interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}