package com.movieappmvvmcleanarchitecture.data.repository.artist.datasource

import com.movieappmvvmcleanarchitecture.data.model.artist.Artist

interface ArtistLocalDatasource {

    suspend fun getArtistsFromDb(): List<Artist>

    suspend fun saveArtistsToDb(artists: List<Artist>)

    suspend fun clearAll()

}