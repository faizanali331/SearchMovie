package com.example.searchmovie.component

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.searchmovie.model.Movie
import com.example.searchmovie.model.Search

@Composable
fun MovieSearchedUI(
    modifier: Modifier = Modifier,
    movie : Search?,
    onClick : (String?)->Unit
) {
    Log.d("MovieSearchedUI", "called")
    Column(
        modifier = Modifier.fillMaxSize().clickable{
            onClick(movie?.imdbID)
        }
    ) {
        if(movie?.poster!=null){
            AsyncImage(
                model = movie.poster,
                contentDescription = "",
                modifier = Modifier.height(150.dp).width(250.dp).clip(shape = RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = movie?.title.toString(),
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = movie?.type.toString(),
            fontSize = 32.sp
        )
        Text(
            text = movie?.year.toString(),
            fontSize = 32.sp
        )
    }
}