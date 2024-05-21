package com.movieappmvvmcleanarchitecture.presentation.di.core

import com.movieappmvvmcleanarchitecture.data.db.ArtistDao
import com.movieappmvvmcleanarchitecture.data.db.MovieDao
import com.movieappmvvmcleanarchitecture.data.db.TvShowDao
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDatasource
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieLocalDatasource
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowLocalDatasource
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasourceImpl.TvshowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun provideMovieLocalDatasource(movieDao: MovieDao): MovieLocalDatasource {
        return MovieLocalDatasourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDatasource(artistDao: ArtistDao): ArtistLocalDatasource {
        return ArtistLocalDatasourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvshowLocalDatasource(tvShowDao: TvShowDao): TvshowLocalDatasource {
        return TvshowLocalDatasourceImpl(tvShowDao)
    }

}