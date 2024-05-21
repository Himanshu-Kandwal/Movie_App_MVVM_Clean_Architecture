package com.movieappmvvmcleanarchitecture.presentation.di.artist

import com.movieappmvvmcleanarchitecture.domain.usecase.GetArtistsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.UpdateArtistsUseCase
import com.movieappmvvmcleanarchitecture.presentation.artist.ArtistViewmodelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewmodelFactory {
        return ArtistViewmodelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}