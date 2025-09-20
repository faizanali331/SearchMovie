package com.example.searchmovie.api

import com.example.searchmovie.model.Movie
import com.example.searchmovie.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET(".")
    suspend fun getMovies(
        @Query("s") title : String,
        @Query("apikey") apiKey: String = "c90390d4"
    ): Response<MovieList>

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") id : String,
        @Query("apikey") apiKey: String = "c90390d4"

    ): Response<Movie>
}