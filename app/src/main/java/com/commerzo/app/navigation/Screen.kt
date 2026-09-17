package com.commerzo.app.navigation

sealed class Screen(
    val route: String
) {
    data object Home : Screen("home")

    data object Practice : Screen("practice")

    data object Tests : Screen("tests")

    data object Games : Screen("games")

    data object Profile : Screen("profile")

    data object Subjects : Screen("subjects")

    data object Chapters : Screen(
        "chapters/{subjectId}/{board}/{classLevel}"
    )

    data object Questions : Screen(
        "questions/{subjectId}/{chapterId}/{board}/{classLevel}"
    )

    data object TestResult : Screen(
        "test_result"
    )

    data object Bookmarks : Screen(
        "bookmarks"
    )

    data object TestHistory : Screen(
        "test_history"
    )

    data object Achievements : Screen(
        "achievements"
    )

    data object Settings : Screen(
        "settings"
    )
}
