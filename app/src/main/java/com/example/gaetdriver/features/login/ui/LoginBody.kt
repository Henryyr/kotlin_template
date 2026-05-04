package com.example.gaetdriver.features.login.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gaetdriver.core.base.i18n.LocalStrings
import com.example.gaetdriver.core.firebase.AuthManager

@Composable
fun LoginBody(
    authManager: AuthManager,
    isLoginMode: Boolean,
    onModeToggle: () -> Unit
) {
    val strings = LocalStrings.current
    
    // These states will automatically reset when LoginScreen changes the 'key'
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    
    val isLoading by authManager.isLoading.collectAsState()
    val error by authManager.error.collectAsState()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (!isLoginMode) {
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text(strings.firstName) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                enabled = !isLoading
            )

            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text(strings.lastName) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                enabled = !isLoading
            )

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text(strings.phoneNumber) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                enabled = !isLoading
            )
        }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(strings.email) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            enabled = !isLoading
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(strings.password) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            enabled = !isLoading
        )

        error?.let {
            Text(
                text = it,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (isLoginMode) {
                    authManager.signIn(email, password)
                } else {
                    authManager.signUp(email, password, firstName, lastName, phone)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            enabled = !isLoading,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.height(24.dp),
                    color = Color.White,
                    strokeWidth = 2.dp
                )
            } else {
                Text(
                    if (isLoginMode) strings.login else strings.signUp,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        TextButton(
            onClick = onModeToggle,
            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoading
        ) {
            Text(
                if (isLoginMode) strings.dontHaveAccount
                else strings.alreadyHaveAccount
            )
        }
    }
}
