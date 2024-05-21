package com.movieappmvvmcleanarchitecture.domain.usecase

import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val moviesRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = moviesRepository.updateMovies()
}