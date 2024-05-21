package com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource

import com.movieappmvvmcleanarchitecture.data.model.movie.MovieList
import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShowList
import retrofit2.Response


interface TvshowRemoteDatasource {
    suspend fun getTvshow(): Response<TvShowList>
}