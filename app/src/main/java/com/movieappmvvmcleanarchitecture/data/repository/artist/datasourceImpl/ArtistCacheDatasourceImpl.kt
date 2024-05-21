package com.movieappmvvmcleanarchitecture.data.repository.artist.datasourceImpl

import com.movieappmvvmcleanarchitecture.data.model.artist.Artist
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDatasource

class ArtistCacheDatasourceImpl : ArtistCacheDatasource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }

}