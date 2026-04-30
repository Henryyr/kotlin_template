package com.example.gaetdriver.constant

import com.example.gaetdriver.R

enum class AppNavDestinations(
    val route: String,
    val icon: Int,
    val label: String
) {
    HOME(route = "home", icon = R.drawable.ic_home, label = "Home"),
    FAVORITES(route = "favorites", icon = R.drawable.ic_favorite, label = "Favorites"),
    ADD(route = "add", icon = R.drawable.ic_add, label = "Add"),
    PROFILE(route = "profile", icon = R.drawable.ic_account_box, label = "Profile"),
    SETTINGS(route = "settings", icon = R.drawable.ic_settings, label = "Settings")
}
