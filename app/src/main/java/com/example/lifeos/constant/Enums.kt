package com.example.lifeos.constant

import com.example.lifeos.R

enum class AppDestinations(
    val route: String,
    val icon: Int,
) {
    HOME("home",  R.drawable.ic_home),
    SETTING("favorite",  R.drawable.ic_favorite),
    ADD(route = "add", R.drawable.ic_add),
    FAVORITES("profile",  R.drawable.ic_account_box),
    PROFILE("setting",  R.drawable.ic_settings),
}

//enum class Status(
//    val label: String,
//) {
//    ACTIVES("Actives", ),
//    UNACTIVES("Unactives"),
//}