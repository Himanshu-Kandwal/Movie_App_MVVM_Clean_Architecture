package com.movieappmvvmcleanarchitecture.data.repository.artist.datasource

import com.movieappmvvmcleanarchitecture.data.model.artist.Artist
import com.movieappmvvmcleanarchitecture.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {

    suspend fun getArtistFromApi(): Response<ArtistList>
}