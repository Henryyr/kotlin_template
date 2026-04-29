package com.example.lifeos.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lifeos.constant.AppDestinations


@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppDestinations.HOME.route,
        modifier = modifier
    ) {

        composable(AppDestinations.HOME.route) {
            /*
            ExamplePage()
            */
        }

        composable(AppDestinations.FAVORITES.route) {  }

        composable(AppDestinations.ADD.route) {  }

        composable(AppDestinations.PROFILE.route) {
        }

        composable(AppDestinations.SETTING.route) {
        }

    }
}