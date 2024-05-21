package com.movieappmvvmcleanarchitecture.data.repository.movie.datasourceImpl

import com.movieappmvvmcleanarchitecture.data.db.MovieDao
import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieLocalDatasourceImpl(private val movieDao: MovieDao) : MovieLocalDatasource {
    override suspend fun getMoviesFromDb(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDb(movies: List<Movie>) {
        withContext(Dispatchers.IO) {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        withContext(Dispatchers.IO) {
            movieDao.deleteAllMovies()
        }
    }
}