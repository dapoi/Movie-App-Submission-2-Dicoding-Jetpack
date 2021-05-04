package com.dapoidev.moviecatalogue.model.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class TVShowEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val title: String,
    @SerializedName("first_air_date")
    val date: String,
    @SerializedName("overview")
    val desc: String,
    @SerializedName("poster_path")
    val image: String
)