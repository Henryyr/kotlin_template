package com.example.gaetdriver.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gaetdriver.constant.AppNavDestinations
import androidx.window.core.layout.WindowSizeClass

@Composable
fun BottomBarNavigation(
    navController: NavController,
    windowSizeClass: WindowSizeClass,
    onAddClick: () -> Unit
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
    val isExpanded = windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND)

    if (isExpanded) {
        NavigationRail(
            containerColor = Color.White.copy(alpha = 0.9f),
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(24.dp)),
            header = {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFFF4917))
                        .clickable { onAddClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(painterResource(AppNavDestinations.ADD.icon), null, tint = Color.White)
                }
            }
        ) {
            AppNavDestinations.entries.filter { it != AppNavDestinations.ADD }.forEach { destination ->
                val isActive = currentDestination == destination.route
                NavigationRailItem(
                    selected = isActive,
                    onClick = { navController.navigate(destination.route) },
                    icon = { Icon(painterResource(destination.icon), null) },
                    label = { Text(destination.label) },
                    colors = NavigationRailItemDefaults.colors(
                        selectedIconColor = Color.Black,
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    } else {
        NavigationBar(
            containerColor = Color.Transparent,
            tonalElevation = 0.dp,
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color.Transparent)
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppNavDestinations.entries.forEach { destination ->
                    val isAdd = destination == AppNavDestinations.ADD
                    val isActive = currentDestination == destination.route

                    Box(
                        modifier = Modifier
                            .size(if (isAdd) 70.dp else 60.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(
                                if (isAdd) Color(0xFFFF4917) else Color.White
                            )
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = ripple(bounded = true)
                            ) {
                                if (isAdd) onAddClick() else navController.navigate(destination.route)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painterResource(destination.icon),
                            contentDescription = destination.route,
                            modifier = Modifier.size(40.dp),
                            tint = when {
                                isAdd -> Color.White
                                isActive -> Color.Black
                                else -> Color.Gray
                            }
                        )
                    }
                }
            }
        }
    }
}
