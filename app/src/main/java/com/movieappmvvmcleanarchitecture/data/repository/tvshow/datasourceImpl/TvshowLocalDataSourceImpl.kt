package com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasourceImpl

import com.movieappmvvmcleanarchitecture.data.db.MovieDao
import com.movieappmvvmcleanarchitecture.data.db.TvShowDao
import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShow
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieLocalDatasource
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowLocalDatasource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TvshowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvshowLocalDatasource {

    override suspend fun getTvshowFromDb(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvshowToDb(tvShow: List<TvShow>) {
        withContext(Dispatchers.IO) {
            tvShowDao.saveTvShows(tvShow)
        }
    }

    override suspend fun clearAll() {
        withContext(Dispatchers.IO) {
            tvShowDao.deleteAllTvShows()
        }
    }
}