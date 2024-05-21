package com.movieappmvvmcleanarchitecture.domain.repository

import com.movieappmvvmcleanarchitecture.data.model.artist.Artist
import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}