package com.movieappmvvmcleanarchitecture.data.repository.artist.datasourceImpl

import com.movieappmvvmcleanarchitecture.data.db.ArtistDao
import com.movieappmvvmcleanarchitecture.data.model.artist.Artist
import com.movieappmvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDatasource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArtistLocalDatasourceImpl(private val artistDao: ArtistDao) : ArtistLocalDatasource {
    override suspend fun getArtistsFromDb(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDb(artists: List<Artist>) {
        withContext(Dispatchers.IO) {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        withContext(Dispatchers.IO) {
            artistDao.deleteAllArtists()
        }
    }
}