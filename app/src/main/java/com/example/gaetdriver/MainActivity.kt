package com.example.gaetdriver

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.gaetdriver.core.ui.components.BottomBarNavigation
import com.example.gaetdriver.core.utils.rememberMediaManager
import com.example.gaetdriver.features.login.LoginScreen
import com.example.gaetdriver.navigation.AppNavHost
import androidx.window.core.layout.WindowSizeClass
import com.example.gaetdriver.core.ui.theme.GaetDriverTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GaetDriverTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    GaetDriverApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@PreviewScreenSizes
@Composable
fun GaetDriverApp() {
    val navController = rememberNavController()
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val isExpanded = windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND)

    var isLoggedIn by remember { mutableStateOf(false) }
    var showAddOptions by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    val mediaManager = rememberMediaManager(
        onImageCaptured = { bitmap ->
            Log.d("Camera", "Captured bitmap: $bitmap")
        },
        onImageSelected = { uri ->
            Log.d("PhotoPicker", "Selected URI: $uri")
        }
    )

    if (!isLoggedIn) {
        LoginScreen(onLoginSuccess = { isLoggedIn = true })
    } else {
        Scaffold(
            bottomBar = {
                if (!isExpanded) {
                    BottomBarNavigation(
                        navController = navController,
                        windowSizeClass = windowSizeClass,
                        onAddClick = { showAddOptions = true }
                    )
                }
            }
        ) { innerPadding ->
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
            ) {
                if (isExpanded) {
                    BottomBarNavigation(
                        navController = navController,
                        windowSizeClass = windowSizeClass,
                        onAddClick = { showAddOptions = true }
                    )
                }
                Box(modifier = Modifier.fillMaxSize()) {
                    AppNavHost(navController)
                }
            }
        }

        if (showAddOptions) {
            ModalBottomSheet(
                onDismissRequest = { showAddOptions = false },
                sheetState = sheetState
            ) {
                Column(modifier = Modifier.padding(bottom = 32.dp)) {
                    ListItem(
                        headlineContent = { Text("Take Photo") },
                        leadingContent = { Icon(Icons.Default.CameraAlt, contentDescription = null) },
                        modifier = Modifier.clickable {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) showAddOptions = false
                            }
                            mediaManager.launchCamera()
                        }
                    )
                    ListItem(
                        headlineContent = { Text("Choose from Gallery") },
                        leadingContent = { Icon(Icons.Default.PhotoLibrary, contentDescription = null) },
                        modifier = Modifier.clickable {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) showAddOptions = false
                            }
                            mediaManager.launchGallery()
                        }
                    )
                }
            }
        }
    }
}
