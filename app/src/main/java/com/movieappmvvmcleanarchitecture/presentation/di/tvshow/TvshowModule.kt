package com.movieappmvvmcleanarchitecture.presentation.di.tvshow

import com.movieappmvvmcleanarchitecture.domain.usecase.GetArtistsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.GetTvShowsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.UpdateArtistsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.UpdateTvShowsUseCase
import com.movieappmvvmcleanarchitecture.presentation.artist.ArtistViewmodelFactory
import com.movieappmvvmcleanarchitecture.presentation.tvshow.TvshowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvshowModule {

    @TvshowScope
    @Provides
    fun provideTvshowViewModelFactory(
        getTvshowsUseCase: GetTvShowsUseCase, updateTvshowsUseCase: UpdateTvShowsUseCase
    ): TvshowViewModelFactory {
        return TvshowViewModelFactory(getTvshowsUseCase, updateTvshowsUseCase)
    }
}