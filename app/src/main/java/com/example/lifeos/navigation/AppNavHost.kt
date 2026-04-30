package com.example.lifeos.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lifeos.constant.AppNavDestinations
import com.example.lifeos.features.home.HomeScreen


@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppNavDestinations.HOME.route,
        modifier = modifier
    ) {
        
        composable(AppNavDestinations.HOME.route) {
            HomeScreen()
        }

        composable(AppNavDestinations.FAVORITES.route) {  }

        composable(AppNavDestinations.ADD.route) {  }

        composable(AppNavDestinations.PROFILE.route) {
        }

        composable(AppNavDestinations.SETTINGS.route) {
        }

    }
}