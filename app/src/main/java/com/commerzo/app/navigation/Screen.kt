package com.commerzo.app.navigation

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * COMMERZO navigation route contract.
 *
 * This file contains route definitions only.
 *
 * Primary destinations:
 * HOME | PRACTICE | TESTS | PROFILE
 *
 * Internal destinations:
 * Subjects, Chapters, Chapter Hub, Questions,
 * Test Session, Test Result, Study Tracker
 * and Profile secondary destinations.
 *
 * IMPORTANT:
 * Existing route strings are intentionally preserved
 * to keep compatibility with AppNavigation and
 * existing navigation state.
 */
sealed class Screen(
    val route: String
) {

    // ============================================================
    // PRIMARY APP DESTINATIONS
    // ============================================================

    data object Home : Screen(
        route = "home"
    )

    data object Practice : Screen(
        route = "practice"
    )

    data object Tests : Screen(
        route = "tests"
    )

    data object Profile : Screen(
        route = "profile"
    )

    // ============================================================
    // INTERNAL / SECONDARY DESTINATIONS
    // ============================================================

    data object Games : Screen(
        route = "games"
    )

    data object StudyTracker : Screen(
        route = "study_tracker"
    )

    data object Subjects : Screen(
        route = "subjects"
    )

    data object TestResult : Screen(
        route = "test_result"
    )

    data object TestHistory : Screen(
        route = "test_history"
    )

    data object Bookmarks : Screen(
        route = "bookmarks"
    )

    data object Achievements : Screen(
        route = "achievements"
    )

    data object Settings : Screen(
        route = "settings"
    )

    // ============================================================
    // STUDY TRACKER SESSION
    // ============================================================

    data object StudyTrackerSession : Screen(
        route = "study_tracker_session/{subjectId}/{chapterId}/{board}/{classLevel}"
    ) {

        fun createRoute(
            subjectId: String,
            chapterId: String,
            board: String,
            classLevel: String
        ): String {
            return buildRoute(
                baseRoute = "study_tracker_session",
                subjectId,
                chapterId,
                board,
                classLevel
            )
        }
    }

    // ============================================================
    // SUBJECT → CHAPTERS
    // ============================================================

    data object Chapters : Screen(
        route = "chapters/{subjectId}/{board}/{classLevel}"
    ) {

        fun createRoute(
            subjectId: String,
            board: String,
            classLevel: String
        ): String {
            return buildRoute(
                baseRoute = "chapters",
                subjectId,
                board,
                classLevel
            )
        }
    }

    // ============================================================
    // CHAPTER HUB
    // ============================================================

    data object ChapterHub : Screen(
        route = "chapter_hub/{subjectId}/{chapterId}/{chapterTitle}/{board}/{classLevel}"
    ) {

        fun createRoute(
            subjectId: String,
            chapterId: String,
            chapterTitle: String,
            board: String,
            classLevel: String
        ): String {
            return buildRoute(
                baseRoute = "chapter_hub",
                subjectId,
                chapterId,
                chapterTitle,
                board,
                classLevel
            )
        }
    }

    // ============================================================
    // PRACTICE QUESTIONS
    // ============================================================

    data object Questions : Screen(
        route = "questions/{subjectId}/{chapterId}/{board}/{classLevel}"
    ) {

        fun createRoute(
            subjectId: String,
            chapterId: String,
            board: String,
            classLevel: String
        ): String {
            return buildRoute(
                baseRoute = "questions",
                subjectId,
                chapterId,
                board,
                classLevel
            )
        }
    }

    // ============================================================
    // TEST SESSION
    // ============================================================

    data object TestSession : Screen(
        route = "test_session/{subjectId}/{chapterId}/{board}/{classLevel}"
    ) {

        fun createRoute(
            subjectId: String,
            chapterId: String,
            board: String,
            classLevel: String
        ): String {
            return buildRoute(
                baseRoute = "test_session",
                subjectId,
                chapterId,
                board,
                classLevel
            )
        }
    }
}

// ================================================================
// ROUTE HELPERS
// ================================================================

/**
 * Builds a navigation route from a base route and
 * encoded path arguments.
 *
 * Keeping this logic centralized prevents inconsistent
 * route construction across the application.
 */
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

/**
 * Encodes a single navigation path argument.
 *
 * Values such as:
 * - spaces
 * - special characters
 * - chapter titles
 * - subject IDs
 *
 * are safely encoded before being inserted into a route.
 */
private fun encodeRouteArgument(
    value: String
): String {
    return URLEncoder.encode(
        value,
        StandardCharsets.UTF_8.name()
    )
}
