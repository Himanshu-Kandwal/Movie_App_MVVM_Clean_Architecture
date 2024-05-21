package com.movieappmvvmcleanarchitecture.data.repository.artist

import android.util.Log
import com.movieappmvvmcleanarchitecture.data.model.artist.Artist
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDatasource
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDatasource
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDatasource
import com.movieappmvvmcleanarchitecture.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDataSource: ArtistCacheDatasource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }


    override suspend fun updateArtists(): List<Artist>? {
        var newListOfArtists: List<Artist> = getArtistsFromApi()

        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDb(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistsFromDb(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDatasource.getArtistsFromDb()
            if (artistList.isNotEmpty()) return artistList
            else {
                artistList = getArtistsFromApi()
                artistLocalDatasource.saveArtistsToDb(artistList)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDatasource.getArtistFromApi()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist>? {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
            if (artistList.isNotEmpty()) return artistList
            else {
                artistList = getArtistsFromDb()
                artistCacheDataSource.saveArtistsToCache(artistList)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }
}