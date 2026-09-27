package com.commerzo.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.commerzo.app.navigation.Screen
import com.commerzo.app.ui.theme.CommerzoBackground
import com.commerzo.app.ui.theme.CommerzoPrimary
import com.commerzo.app.ui.theme.CommerzoPrimaryContainer

@Composable
fun CommerzoBottomBar(
    navController: NavHostController
) {
    val currentDestination =
        navController.currentBackStackEntryAsState().value?.destination?.route

    val items = listOf(
        Triple(Screen.Home, "Home", Icons.Default.Home),
        Triple(Screen.Practice, "Practice", Icons.Default.MenuBook),
        Triple(Screen.Tests, "Tests", Icons.Default.Quiz),
        Triple(Screen.Games, "Games", Icons.Default.SportsEsports),
        Triple(Screen.Profile, "Profile", Icons.Default.AccountCircle)
    )

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp
                )
            ),
        containerColor = Color.White,
        tonalElevation = 0.dp
    ) {
        items.forEach { (screen, label, icon) ->

            val selected = currentDestination == screen.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController.navigate(screen.route) {
                            popUpTo(Screen.Home.route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = label
                    )
                },
                label = {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = CommerzoPrimary,
                    selectedTextColor = CommerzoPrimary,
                    indicatorColor = CommerzoPrimaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    }
}
