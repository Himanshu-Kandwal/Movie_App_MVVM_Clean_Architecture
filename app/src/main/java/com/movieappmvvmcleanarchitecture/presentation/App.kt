package com.movieappmvvmcleanarchitecture.presentation

import android.app.Application
import com.movieappmvvmcleanarchitecture.BuildConfig
import com.movieappmvvmcleanarchitecture.presentation.di.Injector
import com.movieappmvvmcleanarchitecture.presentation.di.artist.ArtistSubComponent
import com.movieappmvvmcleanarchitecture.presentation.di.core.AppComponent
import com.movieappmvvmcleanarchitecture.presentation.di.core.AppModule
import com.movieappmvvmcleanarchitecture.presentation.di.core.DaggerAppComponent
import com.movieappmvvmcleanarchitecture.presentation.di.core.NetModule
import com.movieappmvvmcleanarchitecture.presentation.di.core.RemoteDataModule
import com.movieappmvvmcleanarchitecture.presentation.di.movie.MovieSubComponent
import com.movieappmvvmcleanarchitecture.presentation.di.tvshow.TvshowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY)).build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvSubComponent(): TvshowSubComponent {
        return appComponent.tvShowsSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistComponent().create()
    }
}