package com.commerzo.app.navigation

sealed class Screen(
    val route: String
) {

    data object Home : Screen("home")

    data object Practice : Screen("practice")

    data object Tests : Screen("tests")

    data object Games : Screen("games")

    data object Profile : Screen("profile")

    data object StudyTracker : Screen("study_tracker")

    /**
     * Real study session route.
     *
     * Required arguments:
     * - subjectId
     * - chapterId
     * - board
     * - classLevel
     *
     * These values come from the existing Subject -> Chapter flow.
     */
    data object StudyTrackerSession : Screen(
        "study_tracker_session/{subjectId}/{chapterId}/{board}/{classLevel}"
    ) {
        fun createRoute(
            subjectId: String,
            chapterId: String,
            board: String,
            classLevel: String
        ): String {
            return "study_tracker_session/" +
                "${encodeRouteArgument(subjectId)}/" +
                "${encodeRouteArgument(chapterId)}/" +
                "${encodeRouteArgument(board)}/" +
                "${encodeRouteArgument(classLevel)}"
        }
    }

    data object Subjects : Screen("subjects")

    data object Chapters : Screen(
        "chapters/{subjectId}/{board}/{classLevel}"
    ) {
        fun createRoute(
            subjectId: String,
            board: String,
            classLevel: String
        ): String {
            return "chapters/" +
                "${encodeRouteArgument(subjectId)}/" +
                "${encodeRouteArgument(board)}/" +
                "${encodeRouteArgument(classLevel)}"
        }
    }

    data object Questions : Screen(
        "questions/{subjectId}/{chapterId}/{board}/{classLevel}"
    ) {
        fun createRoute(
            subjectId: String,
            chapterId: String,
            board: String,
            classLevel: String
        ): String {
            return "questions/" +
                "${encodeRouteArgument(subjectId)}/" +
                "${encodeRouteArgument(chapterId)}/" +
                "${encodeRouteArgument(board)}/" +
                "${encodeRouteArgument(classLevel)}"
        }
    }

    data object TestSession : Screen(
        "test_session/{subjectId}/{chapterId}/{board}/{classLevel}"
    ) {
        fun createRoute(
            subjectId: String,
            chapterId: String,
            board: String,
            classLevel: String
        ): String {
            return "test_session/" +
                "${encodeRouteArgument(subjectId)}/" +
                "${encodeRouteArgument(chapterId)}/" +
                "${encodeRouteArgument(board)}/" +
                "${encodeRouteArgument(classLevel)}"
        }
    }

    data object TestResult : Screen("test_result")

    data object Bookmarks : Screen("bookmarks")

    data object TestHistory : Screen("test_history")

    data object Achievements : Screen("achievements")

    data object Settings : Screen("settings")
}

/**
 * Encodes a navigation argument so IDs containing characters such as
 * spaces, slashes, or other reserved URI characters do not break routes.
 */
private fun encodeRouteArgument(value: String): String {
    return java.net.URLEncoder.encode(
        value,
        Charsets.UTF_8.name()
    )
}
