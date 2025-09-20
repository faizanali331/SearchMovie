package com.example.searchmovie.model


import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("Response")
    val response: String?,
    @SerializedName("Search")
    val movies: List<Search?>?,
    @SerializedName("totalResults")
    val totalResults: String?
)