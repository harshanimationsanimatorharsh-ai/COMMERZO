
package com.commerzo.app.navigation

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * COMMERZO navigation route contract.
 *
 * Existing route strings are intentionally preserved
 * for compatibility with AppNavigation and existing
 * navigation state.
 */
sealed class Screen(
    val route: String
) {

    // PRIMARY APP DESTINATIONS

    data object Home : Screen("home")

    data object Practice : Screen("practice")

    data object Tests : Screen("tests")

    data object Profile : Screen("profile")

    // INTERNAL / SECONDARY DESTINATIONS

    data object Games : Screen("games")

    data object StudyTracker : Screen("study_tracker")

    data object Subjects : Screen("subjects")

    data object TestResult : Screen("test_result")

    data object TestHistory : Screen("test_history")

    data object Bookmarks : Screen("bookmarks")

    data object Achievements : Screen("achievements")

    data object Settings : Screen("settings")

    data object About : Screen("about")
    
    data object PrivacyPolicy : Screen("privacy_policy")

    // STUDY RESOURCES

    data object StudyResources : Screen("study_resources")

    // STUDY TRACKER SESSION

    data object StudyTrackerSession : Screen(
        "study_tracker_session/{subjectId}/{chapterId}/{board}/{classLevel}"
    ) {

        fun createRoute(
            subjectId: String,
            chapterId: String,
            board: String,
            classLevel: String
        ): String {
            return buildRoute(
                "study_tracker_session",
                subjectId,
                chapterId,
                board,
                classLevel
            )
        }
    }

    // SUBJECT → CHAPTERS

    data object Chapters : Screen(
        "chapters/{subjectId}/{board}/{classLevel}"
    ) {

        fun createRoute(
            subjectId: String,
            board: String,
            classLevel: String
        ): String {
            return buildRoute(
                "chapters",
                subjectId,
                board,
                classLevel
            )
        }
    }

    // CHAPTER HUB

    data object ChapterHub : Screen(
        "chapter_hub/{subjectId}/{chapterId}/{chapterTitle}/{board}/{classLevel}"
    ) {

        fun createRoute(
            subjectId: String,
            chapterId: String,
            chapterTitle: String,
            board: String,
            classLevel: String
        ): String {
            return buildRoute(
                "chapter_hub",
                subjectId,
                chapterId,
                chapterTitle,
                board,
                classLevel
            )
        }
    }

    // PRACTICE QUESTIONS

    data object Questions : Screen(
        "questions/{subjectId}/{chapterId}/{board}/{classLevel}"
    ) {

        fun createRoute(
            subjectId: String,
            chapterId: String,
            board: String,
            classLevel: String
        ): String {
            return buildRoute(
                "questions",
                subjectId,
                chapterId,
                board,
                classLevel
            )
        }
    }

    // TEST SESSION

    data object TestSession : Screen(
        "test_session/{subjectId}/{chapterId}/{board}/{classLevel}"
    ) {

        fun createRoute(
            subjectId: String,
            chapterId: String,
            board: String,
            classLevel: String
        ): String {
            return buildRoute(
                "test_session",
                subjectId,
                chapterId,
                board,
                classLevel
            )
        }
    }
}

// ROUTE HELPERS

private fun buildRoute(
    baseRoute: String,
    vararg arguments: String
): String {
    if (arguments.isEmpty()) {
        return baseRoute
    }

    return buildString {
        append(baseRoute)

        arguments.forEach { argument ->
            append("/")
            append(encodeRouteArgument(argument))
        }
    }
}

private fun encodeRouteArgument(
    value: String
): String {
    return URLEncoder.encode(
        value,
        StandardCharsets.UTF_8.name()
    )
}
