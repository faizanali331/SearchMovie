package com.example.searchmovie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchmovie.model.Movie
import com.example.searchmovie.model.Search
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    val repo = MovieRepository()
    private val _movies = MutableStateFlow<List<Search?>?>(emptyList())
    val movies : StateFlow<List<Search?>?> = _movies

    fun getMovies(title : String){
        viewModelScope.launch {

            _movies.value = repo.getMovies(title)

        }
    }

    private var _movieDetail = MutableStateFlow<Movie?>(null)
    val movieDetail : StateFlow<Movie?> = _movieDetail

    fun getMovieDetail(id : String){
        viewModelScope.launch {
            _movieDetail.value = repo.getMovieDetail(id);
        }
    }
}