package com.movieappmvvmcleanarchitecture.domain.repository

import com.movieappmvvmcleanarchitecture.data.model.artist.Artist
import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShow

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?

}