package com.example.searchmovie

import android.util.Log
import com.example.searchmovie.api.RetrofitClient
import com.example.searchmovie.model.Movie
import com.example.searchmovie.model.MovieList
import com.example.searchmovie.model.Search
import kotlinx.coroutines.flow.MutableStateFlow

class MovieRepository {
    var retrofitClient = RetrofitClient.movieApiService

    suspend fun getMovies(title : String): List<Search?>?{
        val response = retrofitClient.getMovies(title)

        return response.body()?.movies

    }
    suspend fun getMovieDetail(id : String): Movie?{
        val response = retrofitClient.getMovieDetail(id)
        return response.body()
    }
}