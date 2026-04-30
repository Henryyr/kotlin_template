package com.example.gaetdriver.features.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginHeader() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Welcome Back",
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = "Sign in to continue",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
