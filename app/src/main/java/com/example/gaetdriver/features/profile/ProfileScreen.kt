package com.example.gaetdriver.features.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.gaetdriver.core.base.i18n.LocalStrings
import com.example.gaetdriver.core.firebase.AuthManager
import com.example.gaetdriver.core.ui.components.SectionHeader
import com.example.gaetdriver.core.ui.layout.ViewLayout
import com.example.gaetdriver.core.ui.theme.AccentOrange
import com.example.gaetdriver.core.utils.DeviceManager
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(authManager: AuthManager) {
    val strings = LocalStrings.current
    val context = LocalContext.current
    val deviceManager = remember { DeviceManager(context) }
    val themeMode by deviceManager.themeMode.collectAsState(initial = "system")
    val scope = rememberCoroutineScope()

    ViewLayout(
        header = {
            SectionHeader(title = strings.profileSettings)
        },
        body = {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = strings.themePreference,
                        style = MaterialTheme.typography.titleMedium
                    )

                    ThemeOption(strings.systemDefault, themeMode == "system") {
                        scope.launch { deviceManager.saveThemeMode("system") }
                    }

                    ThemeOption(strings.lightMode, themeMode == "light") {
                        scope.launch { deviceManager.saveThemeMode("light") }
                    }

                    ThemeOption(strings.darkMode, themeMode == "dark") {
                        scope.launch { deviceManager.saveThemeMode("dark") }
                    }
                }






        }
    )
}

@Composable
fun ThemeOption(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label)
        RadioButton(
            selected = isSelected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.primary
            )
        )
    }
}
