package com.dapoidev.moviecatalogue.model.data.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TVShowsResponse(
    @SerializedName("results")
    val result: List<TVShowRemote>
)