package com.dapoidev.moviecatalogue.model.data.remote.response.movie

import com.dapoidev.moviecatalogue.model.data.remote.response.GenreResponse
import com.google.gson.annotations.SerializedName

data class MoviesDetailResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val date: String,
    @SerializedName("genres")
    val genres: List<GenreResponse>,
    @SerializedName("poster_path")
    val imageDetail: String,
    @SerializedName("overview")
    val desc: String
)
