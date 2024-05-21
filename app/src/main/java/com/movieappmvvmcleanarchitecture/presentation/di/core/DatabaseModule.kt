package com.movieappmvvmcleanarchitecture.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.movieappmvvmcleanarchitecture.data.db.ArtistDao
import com.movieappmvvmcleanarchitecture.data.db.MovieDao
import com.movieappmvvmcleanarchitecture.data.db.TMDBDatabase
import com.movieappmvvmcleanarchitecture.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule() {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvshowDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvshowDao()
    }
}