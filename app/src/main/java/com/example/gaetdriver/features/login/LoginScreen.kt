package com.example.gaetdriver.features.login

import androidx.compose.runtime.Composable
import com.example.gaetdriver.core.ui.layout.ViewLayout
import com.example.gaetdriver.features.login.ui.LoginBody
import com.example.gaetdriver.features.login.ui.LoginHeader

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
) {
    ViewLayout(
        header = {
            LoginHeader()
        },
        body = {
            LoginBody(onLoginClick = onLoginSuccess)
        }
    )
}
