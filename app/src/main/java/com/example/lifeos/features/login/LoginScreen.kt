package com.example.lifeos.features.login

import androidx.compose.runtime.Composable
import com.example.lifeos.core.ui.layout.ViewLayout
import com.example.lifeos.features.login.ui.LoginBody
import com.example.lifeos.features.login.ui.LoginHeader

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
