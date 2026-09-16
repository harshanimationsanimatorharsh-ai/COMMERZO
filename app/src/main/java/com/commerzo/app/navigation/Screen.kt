package com.commerzo.app.navigation

sealed class Screen(val route: String) {

    data object Home : Screen("home")

    data object Practice : Screen("practice")

    data object Tests : Screen("tests")

    data object Games : Screen("games")

    data object Profile : Screen("profile")
}
