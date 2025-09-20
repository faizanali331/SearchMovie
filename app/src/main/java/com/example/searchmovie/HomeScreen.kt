package com.example.searchmovie

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.searchmovie.component.MovieSearchedUI

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClick : (String?)-> Unit={},
    movieViewModel: MovieViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val movies = movieViewModel.movies.collectAsState()
    val movieDetail = movieViewModel.movieDetail.collectAsState()

    LaunchedEffect(Unit) {
        movieViewModel.getMovies("Iron man")
    }
    LaunchedEffect(Unit) {
        //movieViewModel.getMovieDetail("id")
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(5.dp)
    ) {
        items(items = movies.value?:emptyList()){movie->
            MovieSearchedUI(movie = movie, onClick = {id->onClick(id)})
            Spacer(
                modifier = Modifier.height(5.dp)
            )

        }

    }

}