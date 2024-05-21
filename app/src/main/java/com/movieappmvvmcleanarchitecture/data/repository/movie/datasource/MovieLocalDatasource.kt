package com.movieappmvvmcleanarchitecture.data.repository.movie.datasource

import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.model.movie.MovieList
import retrofit2.Response

interface MovieLocalDatasource {
    suspend fun getMoviesFromDb(): List<Movie>
    suspend fun saveMoviesToDb(movies: List<Movie>)
    suspend fun clearAll()

}