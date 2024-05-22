package com.movieappmvvmcleanarchitecture.data.repository.tvshow

import android.util.Log
import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShow
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowCacheDatasource
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowLocalDatasource
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowRemoteDatasource
import com.movieappmvvmcleanarchitecture.domain.repository.TvShowRepository

class TvshowRepositoryImpl(
    private val tvshowsRemoteDataSource: TvshowRemoteDatasource,
    private val tvshowsLocalDataSource: TvshowLocalDatasource,
    private val tvshowsCacheDatasource: TvshowCacheDatasource
) : TvShowRepository {


    suspend fun getTvShowsFromApi(): List<TvShow> {
        var tvShowsList: List<TvShow> = ArrayList()

        try {
            val response = tvshowsRemoteDataSource.getTvshow()

            val body = response.body()
            if (body != null) {
                tvShowsList = body.tvShows
            }

        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromDb(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>

        try {
            tvShowsList = tvshowsLocalDataSource.getTvshowFromDb()
            if (tvShowsList.isNotEmpty()) return tvShowsList
            else {
                tvShowsList = getTvShowsFromApi()
                tvshowsLocalDataSource.saveTvshowToDb(tvShowsList)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>

        try {
            tvShowsList = tvshowsCacheDatasource.getTvshowFromCache()
            if (tvShowsList.isNotEmpty()) return tvShowsList
            else {
                tvShowsList = getTvShowsFromDb()
                tvshowsCacheDatasource.saveTvshowsToCache(tvShowsList)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return tvShowsList
    }

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvshows = getTvShowsFromApi()
        tvshowsLocalDataSource.clearAll()

        tvshowsLocalDataSource.saveTvshowToDb(newListOfTvshows)
        tvshowsCacheDatasource.saveTvshowsToCache(newListOfTvshows)
        return newListOfTvshows
    }


}