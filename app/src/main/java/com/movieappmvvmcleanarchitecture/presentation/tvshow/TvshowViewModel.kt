package com.movieappmvvmcleanarchitecture.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.movieappmvvmcleanarchitecture.domain.usecase.GetTvShowsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.UpdateTvShowsUseCase

class TvshowViewModel(
    private val getTvShowUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShows  = getTvShowUseCase.execute()
        emit(tvShows)
    }

    fun updateTvShows() = liveData {
        val tvShows     = updateTvShowsUseCase.execute()
        emit(tvShows)
    }
}