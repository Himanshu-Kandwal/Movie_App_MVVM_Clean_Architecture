package com.movieappmvvmcleanarchitecture.data.api

import com.movieappmvvmcleanarchitecture.data.ArtistList
import com.movieappmvvmcleanarchitecture.data.MovieList
import com.movieappmvvmcleanarchitecture.data.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("api_key") apiKey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String): Response<ArtistList>
}