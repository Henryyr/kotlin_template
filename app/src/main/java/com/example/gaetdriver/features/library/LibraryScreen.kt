package com.example.gaetdriver.features.library

import androidx.compose.runtime.Composable
import com.example.gaetdriver.core.ui.components.EmptyState
import com.example.gaetdriver.core.ui.layout.ViewLayout

@Composable
fun LibraryScreen() {
    ViewLayout(
        header = {
            // Placeholder for Library Header
        },
        body = {
            EmptyState(
                message = "Library is Empty",
                description = "Manage all your data, filter, and search from here."
            )
        }
    )
}
