package com.movieappmvvmcleanarchitecture.presentation.di.tvshow

import com.movieappmvvmcleanarchitecture.presentation.artist.ArtistActivity
import com.movieappmvvmcleanarchitecture.presentation.tvshow.TvshowActivity
import dagger.Subcomponent

@TvshowScope
@Subcomponent(modules = [TvshowModule::class])
interface TvshowSubComponent {
    fun inject(tvshowActivity: TvshowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvshowSubComponent
    }

}