package com.movieappmvvmcleanarchitecture.presentation.artist

import androidx.lifecycle.liveData
import com.movieappmvvmcleanarchitecture.domain.usecase.GetArtistsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.UpdateArtistsUseCase

class ArtistViewmodel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) {

    fun getArtists() = liveData {
        val artists = getArtistsUseCase.execute()
        emit(artists)
    }

    fun updateArtists() = liveData {
        val artists = updateArtistsUseCase.execute()
        emit(artists)
    }

}