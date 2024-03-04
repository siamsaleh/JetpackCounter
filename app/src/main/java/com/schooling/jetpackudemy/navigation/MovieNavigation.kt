package com.schooling.jetpackudemy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.schooling.jetpackudemy.screens.home.HomeScreen
import com.schooling.jetpackudemy.screens.details.DetailScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        // This is Graph
        composable(MovieScreens.HomeScreen.name) {
            // Here we pass where this should lead us to
            HomeScreen(navController = navController)
        }

        // This is Graph
        composable(
            MovieScreens.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) { backStackEntry ->
            // Here we pass where this should lead us to
            DetailScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie")
            )
        }
    }
}