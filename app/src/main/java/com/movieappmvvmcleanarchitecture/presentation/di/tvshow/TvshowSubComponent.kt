package com.movieappmvvmcleanarchitecture.presentation.di.tvshow

import com.movieappmvvmcleanarchitecture.presentation.artist.ArtistActivity
import dagger.Subcomponent

@TvshowScope
@Subcomponent(modules = [TvshowModule::class])
interface TvshowSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvshowSubComponent
    }

}