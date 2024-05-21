package com.movieappmvvmcleanarchitecture.presentation.di

import com.movieappmvvmcleanarchitecture.presentation.di.artist.ArtistSubComponent
import com.movieappmvvmcleanarchitecture.presentation.di.movie.MovieSubComponent
import com.movieappmvvmcleanarchitecture.presentation.di.tvshow.TvshowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvSubComponent(): TvshowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}