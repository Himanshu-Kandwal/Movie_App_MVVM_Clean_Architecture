package com.movieappmvvmcleanarchitecture.presentation.di.movie

import com.movieappmvvmcleanarchitecture.domain.usecase.GetArtistsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.GetMoviesUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.UpdateArtistsUseCase
import com.movieappmvvmcleanarchitecture.domain.usecase.UpdateMoviesUseCase
import com.movieappmvvmcleanarchitecture.presentation.artist.ArtistViewmodelFactory
import com.movieappmvvmcleanarchitecture.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}