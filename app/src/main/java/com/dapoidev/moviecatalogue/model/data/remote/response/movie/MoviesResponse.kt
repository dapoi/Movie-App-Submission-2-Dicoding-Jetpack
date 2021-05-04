package com.dapoidev.moviecatalogue.model.data.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("results")
    val result: List<MovieRemote>
)
