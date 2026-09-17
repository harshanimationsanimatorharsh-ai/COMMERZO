package com.commerzo.app.navigation

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel

sealed class Screen(val route: String) {

    data object Home : Screen("home")

    data object Practice : Screen("practice")

    data object Tests : Screen("tests")

    data object Games : Screen("games")

    data object Profile : Screen("profile")

    data object Subjects : Screen("subjects")

    data object Chapters :
        Screen("chapters/{subjectId}/{board}/{classLevel}") {

        fun createRoute(
            subjectId: String,
            board: Board,
            classLevel: ClassLevel
        ): String =
            "chapters/$subjectId/${board.name}/${classLevel.name}"
    }

    data object Questions :
        Screen("questions/{subjectId}/{chapterId}/{board}/{classLevel}") {

        fun createRoute(
            subjectId: String,
            chapterId: String,
            board: Board,
            classLevel: ClassLevel
        ): String =
            "questions/$subjectId/$chapterId/${board.name}/${classLevel.name}"
    }

    data object TestSession :
        Screen("test_session/{subjectId}/{chapterId}/{board}/{classLevel}") {

        fun createRoute(
            subjectId: String,
            chapterId: String,
            board: Board,
            classLevel: ClassLevel
        ): String =
            "test_session/$subjectId/$chapterId/${board.name}/${classLevel.name}"
    }

    data object TestResult :
        Screen("test_result")

    data object Bookmarks :
        Screen("bookmarks")

    data object TestHistory :
        Screen("test_history")

    data object Achievements :
        Screen("achievements")

    data object Settings :
        Screen("settings")
}
