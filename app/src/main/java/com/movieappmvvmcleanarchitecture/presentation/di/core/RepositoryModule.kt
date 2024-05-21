package com.movieappmvvmcleanarchitecture.presentation.di.core

import com.movieappmvvmcleanarchitecture.data.repository.artist.ArtistRepositoryImpl
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDatasource
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDatasource
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDatasource
import com.movieappmvvmcleanarchitecture.data.repository.movie.MovieRepositoryImpl
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieCacheDatasource
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieLocalDatasource
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieRemoteDatasource
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.TvshowRepositoryImpl
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowCacheDatasource
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowLocalDatasource
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowRemoteDatasource
import com.movieappmvvmcleanarchitecture.domain.repository.ArtistRepository
import com.movieappmvvmcleanarchitecture.domain.repository.MovieRepository
import com.movieappmvvmcleanarchitecture.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDatasource: ArtistCacheDatasource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDatasource,
            artistCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideTvshowRepository(
        tvshowRemoteDataSource: TvshowRemoteDatasource,
        tvshowLocalDataSource: TvshowLocalDatasource,
        tvshowCacheDatasource: TvshowCacheDatasource
    ): TvShowRepository {
        return TvshowRepositoryImpl(
            tvshowRemoteDataSource,
            tvshowLocalDataSource,
            tvshowCacheDatasource
        )
    }

}