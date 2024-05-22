package com.movieappmvvmcleanarchitecture.data.repository.movie

import android.util.Log
import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieCacheDatasource
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieLocalDatasource
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieRemoteDatasource
import com.movieappmvvmcleanarchitecture.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDatasource,
    private val movieLocalDataSource: MovieLocalDatasource,
    private val movieCacheDatasource: MovieCacheDatasource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()

    }

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()

        movieLocalDataSource.saveMoviesToDb(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        var movieList: List<Movie> = ArrayList()

        try {
            val response = movieRemoteDataSource.getMovies()

            val body = response.body()
            if (body != null) {
                movieList = body.movies
                Log.i(
                    "MyTag",
                    "fetched movies from Api: ${System.currentTimeMillis()} $movieList"
                )
            }

        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDb(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDb()
            if (movieList.isNotEmpty()) {
                Log.i(
                    "MyTag",
                    "fetched movies from DB: ${System.currentTimeMillis()} $movieList"
                )
                return movieList
            } else {
                movieList = getMoviesFromApi()
                movieLocalDataSource.saveMoviesToDb(movieList)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDatasource.getMoviesFromCache()
            if (movieList.isNotEmpty()) {
                Log.i(
                    "MyTag",
                    "fetched movies from Cache: ${System.currentTimeMillis()} $movieList"
                )
                return movieList
            } else {
                movieList = getMoviesFromDb()
                movieCacheDatasource.saveMoviesToCache(movieList)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return movieList
    }


}