package com.movieappmvvmcleanarchitecture.presentation.di.movie

import com.movieappmvvmcleanarchitecture.presentation.artist.ArtistActivity
import com.movieappmvvmcleanarchitecture.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }

}