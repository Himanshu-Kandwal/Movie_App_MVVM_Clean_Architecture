package com.movieappmvvmcleanarchitecture.domain.usecase

import com.movieappmvvmcleanarchitecture.data.model.artist.Artist
import com.movieappmvvmcleanarchitecture.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? {
        return artistRepository.getArtists()
    }

}