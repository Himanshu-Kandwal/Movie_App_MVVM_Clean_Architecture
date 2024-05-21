package com.movieappmvvmcleanarchitecture.data.repository.movie.datasource

import com.movieappmvvmcleanarchitecture.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache(): List<Movie>
     suspend fun saveMoviesToCache(movies: List<Movie>)

}