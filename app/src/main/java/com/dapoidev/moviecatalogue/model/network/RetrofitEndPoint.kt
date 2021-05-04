package com.dapoidev.moviecatalogue.model.network

import com.dapoidev.moviecatalogue.BuildConfig
import com.dapoidev.moviecatalogue.model.data.remote.response.movie.MoviesDetailResponse
import com.dapoidev.moviecatalogue.model.data.remote.response.movie.MoviesResponse
import com.dapoidev.moviecatalogue.model.data.remote.response.tvshow.TVShowsDetailResponse
import com.dapoidev.moviecatalogue.model.data.remote.response.tvshow.TVShowsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitEndPoint {

    companion object {
        const val API_KEY = BuildConfig.API_KEY
    }

    @GET("movie/popular?api_key=$API_KEY")
    fun getListMovies(
        @Query("page") page: Int
    ): Call<MoviesResponse>

    @GET("movie/{movie_id}?api_key=$API_KEY")
    fun getDetailMovies(
        @Path("movie_id") id: String
    ): Call<MoviesDetailResponse>

    @GET("tv/popular?api_key=$API_KEY")
    fun getListTVShows(
        @Query("page") page: Int
    ): Call<TVShowsResponse>

    @GET("tv/{tv_id}?api_key=$API_KEY")
    fun getDetailTVShows(
        @Path("tv_id") id: String
    ): Call<TVShowsDetailResponse>
}