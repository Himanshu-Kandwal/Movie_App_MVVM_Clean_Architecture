package com.movieappmvvmcleanarchitecture.data.repository.artist.datasource

import com.movieappmvvmcleanarchitecture.data.model.artist.Artist

interface ArtistCacheDatasource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}