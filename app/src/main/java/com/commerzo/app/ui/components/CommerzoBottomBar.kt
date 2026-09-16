package com.commerzo.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.commerzo.app.navigation.Screen

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

    NavigationBar {

        items.forEach { (screen, label, icon) ->

            NavigationBarItem(
                selected = currentDestination == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(Screen.Home.route)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = label
                    )
                },
                label = {
                    Text(label)
                }
            )
        }
    }
}
