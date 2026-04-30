package com.example.gaetdriver.features.activity

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gaetdriver.core.ui.components.EmptyState
import com.example.gaetdriver.core.ui.layout.ViewLayout

@Composable
fun ActivityScreen() {
    ViewLayout(
        header = {
            // Placeholder for Activity Header
        },
        body = {
            EmptyState(
                message = "No Activity Yet",
                description = "Your upload history and logs will appear here."
            )
        }
    )
}
