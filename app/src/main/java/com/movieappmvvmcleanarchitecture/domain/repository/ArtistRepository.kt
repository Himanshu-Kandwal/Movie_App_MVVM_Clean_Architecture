package com.movieappmvvmcleanarchitecture.domain.repository

import com.movieappmvvmcleanarchitecture.data.model.artist.Artist
import com.movieappmvvmcleanarchitecture.data.model.movie.Movie
import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShow

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?

}