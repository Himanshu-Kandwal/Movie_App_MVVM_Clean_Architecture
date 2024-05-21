package com.movieappmvvmcleanarchitecture.domain.usecase

import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.domain.repository.MovieRepository

class GetMoviesUseCase(private val moviesRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? {
        return moviesRepository.getMovies()
    }

}