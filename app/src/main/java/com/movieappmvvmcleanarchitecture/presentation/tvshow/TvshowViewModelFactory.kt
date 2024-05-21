package com.movieappmvvmcleanarchitecture.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.movieappmvvmcleanarchitecture.domain.usecase.GetTvShowsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.UpdateTvShowsUseCase

class TvshowViewModelFactory(
    private val getTvShowUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvshowViewModel(getTvShowUseCase, updateTvShowsUseCase) as T
    }
}