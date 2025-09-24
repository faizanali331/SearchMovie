package com.example.searchmovie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.searchmovie.component.MovieSearchedUI
import com.example.searchmovie.component.SearchField

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClick : (String?)-> Unit,
    movieViewModel: MovieViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val movies = movieViewModel.movies.collectAsState()

    var searchText by remember { mutableStateOf("war") }

    LaunchedEffect(searchText) {
        movieViewModel.getMovies(searchText)
    }
//    LaunchedEffect(Unit) {
//        movieViewModel.getMovieDetail("id")
//    }
    Column(
        modifier = Modifier.fillMaxSize().padding(12.dp)

    ) {
        SearchField(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            hint = "Type here...",
            title = "",
            onChange = {
                searchText = it
            },
            searchText = searchText
        )
        Spacer(modifier = Modifier.padding(8.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(5.dp)
        ) {
            items(items = movies.value ?: emptyList()) { movie ->
                MovieSearchedUI(movie = movie, onClick = { id -> onClick(id) })
                Spacer(
                    modifier = Modifier.height(5.dp)
                )

            }

        }
    }

}