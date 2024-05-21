package com.movieappmvvmcleanarchitecture.presentation.di.core

import com.movieappmvvmcleanarchitecture.presentation.di.artist.ArtistSubComponent
import com.movieappmvvmcleanarchitecture.presentation.di.movie.MovieSubComponent
import com.movieappmvvmcleanarchitecture.presentation.di.tvshow.TvshowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, NetModule::class, DatabaseModule::class, UsecaseModule::class, RepositoryModule::class, RemoteDataModule::class, LocalDataModule::class, CacheDataModule::class]
)
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowsSubComponent(): TvshowSubComponent.Factory
    fun artistComponent(): ArtistSubComponent.Factory

}