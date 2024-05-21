package com.movieappmvvmcleanarchitecture.presentation.di.core

import com.movieappmvvmcleanarchitecture.data.db.ArtistDao
import com.movieappmvvmcleanarchitecture.data.db.MovieDao
import com.movieappmvvmcleanarchitecture.data.db.TvShowDao
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDatasource
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieCacheDatasource
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowCacheDatasource
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasourceImpl.TvshowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule() {
    @Singleton
    @Provides
    fun provideMovieCacheDatasource(): MovieCacheDatasource {
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDatasource(): ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvshowCacheDatasource(): TvshowCacheDatasource {
        return TvshowCacheDatasourceImpl()
    }

}