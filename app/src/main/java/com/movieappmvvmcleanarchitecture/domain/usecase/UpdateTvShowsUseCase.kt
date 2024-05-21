package com.movieappmvvmcleanarchitecture.domain.usecase

import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShow
import com.movieappmvvmcleanarchitecture.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}