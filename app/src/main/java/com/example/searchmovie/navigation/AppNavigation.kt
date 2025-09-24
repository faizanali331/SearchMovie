package com.example.searchmovie.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.searchmovie.HomeScreen
import com.example.searchmovie.MovieDetail

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = HomeDestination.HomeScreen.route){
        composable(
            HomeDestination.HomeScreen.route
        ) {
            HomeScreen(onClick={id->
                navController.navigate(HomeDestination.MovieDetail.createRoute(id))
            })
        }
        composable(
            route = HomeDestination.MovieDetail.route,
            arguments = listOf(navArgument("id"){
                type = NavType.StringType
            })
        ){
            backStackEntry->
            val id = backStackEntry.arguments?.getString("id")?:""
            MovieDetail(movieId = id)
        }
    }
}