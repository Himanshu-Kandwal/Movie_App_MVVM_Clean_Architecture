package com.movieappmvvmcleanarchitecture.presentation.di.core

import com.movieappmvvmcleanarchitecture.data.api.TMDBService
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDatasource
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieRemoteDatasource
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowRemoteDatasource
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasourceImpl.TvshowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDatasourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDatasourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvshowRemoteDatasource {
        return TvshowRemoteDatasourceImpl(tmdbService, apiKey)
    }

}