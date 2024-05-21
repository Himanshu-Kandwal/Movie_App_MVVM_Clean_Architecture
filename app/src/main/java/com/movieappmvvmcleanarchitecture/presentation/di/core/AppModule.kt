package com.movieappmvvmcleanarchitecture.presentation.di.core

import android.content.Context
import com.movieappmvvmcleanarchitecture.presentation.di.artist.ArtistSubComponent
import com.movieappmvvmcleanarchitecture.presentation.di.movie.MovieSubComponent
import com.movieappmvvmcleanarchitecture.presentation.di.tvshow.TvshowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [
        MovieSubComponent::class, TvshowSubComponent::class, ArtistSubComponent::class
    ]
)
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context = context.applicationContext
}