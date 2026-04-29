package com.example.lifeos.features.home

import androidx.compose.runtime.Composable
import com.example.lifeos.core.ui.layout.ViewLayout
import com.example.lifeos.features.home.ui.BodyContent
import com.example.lifeos.features.home.ui.HeaderContent

@Composable
fun HomeScreen() {
    ViewLayout(
        header = {
            HeaderContent()
        },
        body = {
            BodyContent()
        }
    )
}