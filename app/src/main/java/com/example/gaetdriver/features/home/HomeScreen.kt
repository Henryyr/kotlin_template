package com.example.gaetdriver.features.home

import androidx.compose.runtime.Composable
import com.example.gaetdriver.core.ui.layout.ViewLayout
import com.example.gaetdriver.features.home.ui.BodyContent
import com.example.gaetdriver.features.home.ui.HeaderContent

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