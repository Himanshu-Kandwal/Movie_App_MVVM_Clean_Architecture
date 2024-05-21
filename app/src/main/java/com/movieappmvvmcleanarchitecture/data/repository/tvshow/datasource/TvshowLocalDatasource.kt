package com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource

import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShow

interface TvshowLocalDatasource {
    suspend fun getTvshowFromDb(): List<TvShow>
    suspend fun saveTvshowToDb(tvShow: List<TvShow>)
    suspend fun clearAll()

}