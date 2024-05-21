package com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasourceImpl

import com.movieappmvvmcleanarchitecture.data.api.TMDBService
import com.movieappmvvmcleanarchitecture.data.model.movie.MovieList
import com.movieappmvvmcleanarchitecture.data.model.tvshow.TvShowList
import com.movieappmvvmcleanarchitecture.data.repository.movie.datasource.MovieRemoteDatasource
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowLocalDatasource
import com.movieappmvvmcleanarchitecture.data.repository.tvshow.datasource.TvshowRemoteDatasource
import retrofit2.Response

class TvshowRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    TvshowRemoteDatasource {
    override suspend fun getTvshow(): Response<TvShowList> {
        return tmdbService.getPopularTVShows(apiKey)
    }


}