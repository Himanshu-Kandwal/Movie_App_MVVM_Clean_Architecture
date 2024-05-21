package com.movieappmvvmcleanarchitecture.data.repository.artist.datasourceImpl

import com.movieappmvvmcleanarchitecture.data.api.TMDBService
import com.movieappmvvmcleanarchitecture.data.model.artist.ArtistList
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(private val tmdbService: TMDBService, val apiKey: String) :
    ArtistRemoteDatasource {
    override suspend fun getArtistFromApi(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}