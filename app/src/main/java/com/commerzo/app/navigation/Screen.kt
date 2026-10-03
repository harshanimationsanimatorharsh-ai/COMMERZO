package com.commerzo.app.navigation

sealed class Screen(
    val route: String
) {

    // ─────────────────────────────────────────────────────────────
    // ROOT DESTINATIONS
    // ─────────────────────────────────────────────────────────────

    data object Home : Screen("home")

    data object Practice : Screen("practice")

    data object Tests : Screen("tests")

    /*
     * Compatibility route.
     *
     * Games must NOT remain a root bottom-navigation destination
     * in the final IA. It will eventually live inside:
     *
     * Practice → More → Games
     *
     * Keep this route temporarily so existing navigation references
     * do not break before AppNavigation is migrated.
     */
    data object Games : Screen("games")

    data object Profile : Screen("profile")


    // ─────────────────────────────────────────────────────────────
    // STUDY TRACKER
    // ─────────────────────────────────────────────────────────────

    data object StudyTracker : Screen("study_tracker")

    /**
     * Real study session route.
     *
     * Required arguments:
     * - subjectId
     * - chapterId
     * - board
     * - classLevel
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


    // ─────────────────────────────────────────────────────────────
    // LEARNING FLOW
    // ─────────────────────────────────────────────────────────────

    /**
     * Subjects are an internal learning destination.
     *
     * They should NOT be a bottom-navigation destination in the
     * final four-tab architecture.
     */
    data object Subjects : Screen("subjects")

    /**
     * Chapter list for a selected subject.
     */
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

    /**
     * Central chapter destination.
     *
     * Target learning flow:
     *
     * Subject
     *     ↓
     * Chapter
     *     ↓
     * Chapter Hub
     *     ├── Notes
     *     ├── Practice
     *     ├── Test
     *     ├── PDFs
     *     └── PYQs
     *
     * This route is introduced now so navigation can migrate
     * toward the target information architecture.
     */
    data object ChapterHub : Screen(
        "chapter_hub/{subjectId}/{chapterId}/{board}/{classLevel}"
    ) {
        fun createRoute(
            subjectId: String,
            chapterId: String,
            board: String,
            classLevel: String
        ): String {
            return "chapter_hub/" +
                "${encodeRouteArgument(subjectId)}/" +
                "${encodeRouteArgument(chapterId)}/" +
                "${encodeRouteArgument(board)}/" +
                "${encodeRouteArgument(classLevel)}"
        }
    }


    // ─────────────────────────────────────────────────────────────
    // QUESTION / PRACTICE FLOW
    // ─────────────────────────────────────────────────────────────

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


    // ─────────────────────────────────────────────────────────────
    // TEST FLOW
    // ─────────────────────────────────────────────────────────────

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

    data object TestHistory : Screen("test_history")


    // ─────────────────────────────────────────────────────────────
    // PERSONAL / PROGRESS
    // ─────────────────────────────────────────────────────────────

    data object Bookmarks : Screen("bookmarks")

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
