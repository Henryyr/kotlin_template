package com.example.gaetdriver.features.activity

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gaetdriver.core.base.i18n.LocalStrings
import com.example.gaetdriver.core.ui.components.EmptyState
import com.example.gaetdriver.core.ui.layout.ViewLayout

@Composable
fun ActivityScreen() {
    val strings = LocalStrings.current
    ViewLayout(
        header = {
            // Placeholder for Activity Header
        },
        body = {
            EmptyState(
                message = strings.noActivity,
                description = strings.noActivityDescription
            )
        }
    )
}
