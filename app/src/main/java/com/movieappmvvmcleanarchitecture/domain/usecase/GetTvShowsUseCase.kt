package com.movieappmvvmcleanarchitecture.domain.usecase

import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShow
import com.movieappmvvmcleanarchitecture.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? {
        return tvShowRepository.getTvShows()
    }

}