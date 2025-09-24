package com.example.searchmovie.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class HomeDestination(val route:  String) {
    @Serializable
    object HomeScreen: HomeDestination("home_screen")
    @Serializable
    object MovieDetail: HomeDestination("details/{id}"){
        fun createRoute(id: String?)="details/$id"
    }
}