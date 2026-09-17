package com.commerzo.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.commerzo.app.ui.screens.AchievementsScreen
import com.commerzo.app.ui.screens.BookmarksScreen
import com.commerzo.app.ui.screens.ChapterScreen
import com.commerzo.app.ui.screens.HomeScreen
import com.commerzo.app.ui.screens.ProfileScreen
import com.commerzo.app.ui.screens.QuestionScreen
import com.commerzo.app.ui.screens.SettingsScreen
import com.commerzo.app.ui.screens.SubjectSelectionScreen
import com.commerzo.app.ui.screens.TestHistoryScreen
import com.commerzo.app.ui.screens.TestResultScreen
import com.commerzo.app.ui.screens.TestScreen
import com.commerzo.app.ui.screens.GamesScreen
import com.commerzo.app.ui.screens.PracticeScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        composable("practice") {
            PracticeScreen(
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        composable("tests") {
            TestScreen(
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                onTestFinished = { _, _, _, _, _, _ ->
                    navController.navigate("test_result")
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable("games") {
            GamesScreen()
        }

        composable("profile") {
            ProfileScreen(
                onBookmarks = {
                    navController.navigate("bookmarks")
                },
                onTestHistory = {
                    navController.navigate("test_history")
                },
                onAchievements = {
                    navController.navigate("achievements")
                },
                onSettings = {
                    navController.navigate("settings")
                }
            )
        }

        composable("subjects") {
            SubjectSelectionScreen(
                onSubjectSelected = { subject ->
                    navController.navigate(
                        "chapters/${subject.id}/${subject.board.name}/${subject.classLevel.name}"
                    )
                }
            )
        }

        composable(
            route = "chapters/{subjectId}/{board}/{classLevel}"
        ) { backStackEntry ->

            val subjectId =
                backStackEntry.arguments
                    ?.getString("subjectId")
                    ?: return@composable

            val board =
                backStackEntry.arguments
                    ?.getString("board")
                    ?: "MP_BOARD"

            val classLevel =
                backStackEntry.arguments
                    ?.getString("classLevel")
                    ?: "CLASS_12"

            ChapterScreen(
                subjectId = subjectId,
                board = enumValueOrDefault(
                    value = board,
                    default = com.commerzo.app.data.model.Board.MP_BOARD
                ),
                classLevel = enumValueOrDefault(
                    value = classLevel,
                    default = com.commerzo.app.data.model.ClassLevel.CLASS_12
                ),
                onChapterSelected = { chapter ->
                    navController.navigate(
                        "questions/${chapter.subjectId}/${chapter.id}"
                    )
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "questions/{subjectId}/{chapterId}"
        ) { backStackEntry ->

            val subjectId =
                backStackEntry.arguments
                    ?.getString("subjectId")
                    ?: return@composable

            val chapterId =
                backStackEntry.arguments
                    ?.getString("chapterId")
                    ?: return@composable

            QuestionScreen(
                subjectId = subjectId,
                chapterId = chapterId,
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable("test_result") {
            TestResultScreen(
                onRestart = {
                    navController.navigate("tests") {
                        popUpTo("tests") {
                            inclusive = true
                        }
                    }
                },
                onBackToTests = {
                    navController.navigate("tests") {
                        popUpTo("tests") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("bookmarks") {
            BookmarksScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable("test_history") {
            TestHistoryScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable("achievements") {
            AchievementsScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable("settings") {
            SettingsScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

private inline fun <reified T : Enum<T>> enumValueOrDefault(
    value: String,
    default: T
): T {
    return try {
        enumValueOf<T>(value)
    } catch (_: IllegalArgumentException) {
        default
    }
}
