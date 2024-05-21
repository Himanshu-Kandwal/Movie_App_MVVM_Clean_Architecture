package com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource

import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShow

interface TvshowCacheDatasource {
    suspend fun getTvshowFromCache(): List<TvShow>
    suspend fun saveTvshowsToCache(tvShows: List<TvShow>)

}