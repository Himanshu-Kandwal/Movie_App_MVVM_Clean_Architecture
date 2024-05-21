package com.movieappmvvmcleanarchitecture.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.movieappmvvmcleanarchitecture.domain.usecase.GetArtistsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.UpdateArtistsUseCase

class ArtistViewmodelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewmodel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}