package com.commerzo.app.navigation

sealed class Screen(
    val route: String
) {

    data object Home :
        Screen("home")

    data object Practice :
        Screen("practice")

    data object Tests :
        Screen("tests")

    data object Games :
        Screen("games")

    data object Profile :
        Screen("profile")

    data object SubjectSelection :
        Screen("subject_selection")

    data object Chapters :
        Screen("chapters/{subjectId}") {

        fun createRoute(
            subjectId: String
        ): String {
            return "chapters/$subjectId"
        }
    }

    data object Questions :
        Screen(
            "questions/{subjectId}/{chapterId}"
        ) {

        fun createRoute(
            subjectId: String,
            chapterId: String
        ): String {

            return "questions/$subjectId/$chapterId"
        }
    }

    data object Test :
        Screen(
            "test/{subjectId}/{chapterId}"
        ) {

        fun createRoute(
            subjectId: String,
            chapterId: String
        ): String {

            return "test/$subjectId/$chapterId"
        }
    }
}
