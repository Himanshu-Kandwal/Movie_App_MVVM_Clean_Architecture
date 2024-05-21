package com.movieappmvvmcleanarchitecture.data.model.artist


import com.google.gson.annotations.SerializedName

data class Artist(

    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)