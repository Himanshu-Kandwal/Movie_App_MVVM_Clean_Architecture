package com.movieappmvvmcleanarchitecture.data.repository.movie.datasourceImpl

import com.movieappmvvmcleanarchitecture.data.api.TMDBService
import com.movieappmvvmcleanarchitecture.data.model.movie.MovieList
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }

}