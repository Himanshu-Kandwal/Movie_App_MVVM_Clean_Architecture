package com.movieappmvvmcleanarchitecture.presentation.di.core

import com.movieappmvvmcleanarchitecture.domain.repository.ArtistRepository
import com.movieappmvvmcleanarchitecture.domain.repository.MovieRepository
import com.movieappmvvmcleanarchitecture.domain.repository.TvShowRepository
import com.movieappmvvmcleanarchitecture.domain.usecase.GetArtistsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.GetMoviesUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.GetTvShowsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.UpdateArtistsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.UpdateMoviesUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UsecaseModule {

    @Provides
    fun providesGetMoviesUseCase(moviesRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(moviesRepository)
    }

    @Provides
    fun providesUpdateMoviesUseCase(moviesRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(moviesRepository)
    }

    @Provides
    fun providesGetTvshowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun providesUpdateTvshowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun providesGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun providesUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }


}