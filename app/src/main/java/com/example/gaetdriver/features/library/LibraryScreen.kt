package com.example.gaetdriver.features.library

import androidx.compose.runtime.Composable
import com.example.gaetdriver.core.base.i18n.LocalStrings
import com.example.gaetdriver.core.ui.components.EmptyState
import com.example.gaetdriver.core.ui.layout.ViewLayout

@Composable
fun LibraryScreen() {
    val strings = LocalStrings.current
    ViewLayout(
        header = {
            // Placeholder for Library Header
        },
        body = {
            EmptyState(
                message = strings.libraryEmpty,
                description = strings.libraryDescription
            )
        }
    )
}
