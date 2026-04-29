package com.example.lifeos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.compose.rememberNavController
import com.example.lifeos.core.ui.theme.LifeOSTheme
import com.example.lifeos.features.home.ui.BottomBarNavigation
import com.example.lifeos.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifeOSTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    LifeOSApp()
                }
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun LifeOSApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBarNavigation(navController) }
    ) {
        padding -> Box(
            modifier = Modifier.padding(padding)
        ) {
        AppNavHost(navController)
    }
    }

    }

