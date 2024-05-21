package com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasourceImpl

import com.movieappmvvmcleanarchitecture.data.model.artist.Artist
import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShow
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieCacheDatasource
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowCacheDatasource

class TvshowCacheDatasourceImpl : TvshowCacheDatasource {

    private var tvshowList = ArrayList<TvShow>()
    override suspend fun getTvshowFromCache(): List<TvShow> {
        return tvshowList
    }

    override suspend fun saveTvshowsToCache(tvShows: List<TvShow>) {
        tvshowList.clear()
        tvshowList = ArrayList(tvShows)
    }

}