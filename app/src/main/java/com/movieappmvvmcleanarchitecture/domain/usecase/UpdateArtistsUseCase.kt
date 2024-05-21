package com.movieappmvvmcleanarchitecture.domain.usecase

import com.movieappmvvmcleanarchitecture.data.model.artist.Artist
import com.movieappmvvmcleanarchitecture.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistsRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistsRepository.updateArtists()
}