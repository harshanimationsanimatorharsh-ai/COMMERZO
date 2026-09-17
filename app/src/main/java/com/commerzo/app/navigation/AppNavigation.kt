package com.commerzo.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.repository.SubjectRepository
import com.commerzo.app.ui.screens.AchievementsScreen
import com.commerzo.app.ui.screens.BookmarksScreen
import com.commerzo.app.ui.screens.ChapterScreen
import com.commerzo.app.ui.screens.GamesScreen
import com.commerzo.app.ui.screens.HomeScreen
import com.commerzo.app.ui.screens.PracticeScreen
import com.commerzo.app.ui.screens.ProfileScreen
import com.commerzo.app.ui.screens.QuestionScreen
import com.commerzo.app.ui.screens.SettingsScreen
import com.commerzo.app.ui.screens.SubjectSelectionScreen
import com.commerzo.app.ui.screens.TestHistoryScreen
import com.commerzo.app.ui.screens.TestResultScreen
import com.commerzo.app.ui.screens.TestScreen

data class NavigationTestResult(
    val total: Int = 0,
    val answered: Int = 0,
    val correct: Int = 0,
    val wrong: Int = 0,
    val unattempted: Int = 0,
    val marked: Int = 0
)

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    var latestTestResult by remember {
        mutableStateOf(NavigationTestResult())
    }

    val subjectRepository = remember {
        SubjectRepository()
    }

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        // ---------------------------------------------------------
        // HOME
        // ---------------------------------------------------------
        composable("home") {
            HomeScreen(
                onSubjectClick = { subjectId ->
                    navController.navigate(
                        "chapters/$subjectId/MP_BOARD/CLASS_12"
                    )
                }
            )
        }

        // ---------------------------------------------------------
        // PRACTICE
        // ---------------------------------------------------------
        composable("practice") {
            PracticeScreen(
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        // ---------------------------------------------------------
        // TESTS
        // ---------------------------------------------------------
        composable("tests") {
            TestScreen(
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                onTestFinished = {
                        total,
                        answered,
                        correct,
                        wrong,
                        unattempted,
                        marked
                    ->
                    latestTestResult = NavigationTestResult(
                        total = total,
                        answered = answered,
                        correct = correct,
                        wrong = wrong,
                        unattempted = unattempted,
                        marked = marked
                    )

                    navController.navigate("test_result")
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        // ---------------------------------------------------------
        // GAMES
        // ---------------------------------------------------------
        composable("games") {
            GamesScreen()
        }

        // ---------------------------------------------------------
        // PROFILE
        // ---------------------------------------------------------
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

        // ---------------------------------------------------------
        // SUBJECT SELECTION
        // ---------------------------------------------------------
        composable("subjects") {
            SubjectSelectionScreen(
                viewModel = viewModel(),
                onSubjectClick = { subject ->
                    navController.navigate(
                        "chapters/" +
                            "${subject.id}/" +
                            "${subject.board.name}/" +
                            "${subject.classLevel.name}"
                    )
                }
            )
        }

        // ---------------------------------------------------------
        // CHAPTERS
        // ---------------------------------------------------------
        composable(
            route = "chapters/{subjectId}/{board}/{classLevel}"
        ) { backStackEntry ->

            val subjectId =
                backStackEntry.arguments
                    ?.getString("subjectId")
                    ?: return@composable

            val board =
                enumValueOrDefault(
                    value = backStackEntry.arguments
                        ?.getString("board")
                        ?: "MP_BOARD",
                    default = Board.MP_BOARD
                )

            val classLevel =
                enumValueOrDefault(
                    value = backStackEntry.arguments
                        ?.getString("classLevel")
                        ?: "CLASS_12",
                    default = ClassLevel.CLASS_12
                )

            val subjectName =
                subjectRepository
                    .getSubjects(
                        board = board,
                        classLevel = classLevel
                    )
                    .firstOrNull { it.id == subjectId }
                    ?.name
                    ?: subjectId

            ChapterScreen(
                subjectId = subjectId,
                subjectName = subjectName,
                board = board,
                classLevel = classLevel,
                onBack = {
                    navController.popBackStack()
                },
                onChapterClick = { chapterId, _ ->
                    navController.navigate(
                        "questions/" +
                            "$subjectId/" +
                            "$chapterId/" +
                            "${board.name}/" +
                            "${classLevel.name}"
                    )
                }
            )
        }

        // ---------------------------------------------------------
        // QUESTIONS / PRACTICE
        // ---------------------------------------------------------
        composable(
            route = "questions/{subjectId}/{chapterId}/{board}/{classLevel}"
        ) { backStackEntry ->

            val subjectId =
                backStackEntry.arguments
                    ?.getString("subjectId")
                    ?: return@composable

            val chapterId =
                backStackEntry.arguments
                    ?.getString("chapterId")
                    ?: return@composable

            val board =
                enumValueOrDefault(
                    value = backStackEntry.arguments
                        ?.getString("board")
                        ?: "MP_BOARD",
                    default = Board.MP_BOARD
                )

            val classLevel =
                enumValueOrDefault(
                    value = backStackEntry.arguments
                        ?.getString("classLevel")
                        ?: "CLASS_12",
                    default = ClassLevel.CLASS_12
                )

            QuestionScreen(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        // ---------------------------------------------------------
        // TEST RESULT
        // ---------------------------------------------------------
        composable("test_result") {
            TestResultScreen(
                total = latestTestResult.total,
                answered = latestTestResult.answered,
                correct = latestTestResult.correct,
                wrong = latestTestResult.wrong,
                unattempted = latestTestResult.unattempted,
                marked = latestTestResult.marked,
                onRestart = {
                    latestTestResult = NavigationTestResult()

                    navController.navigate("tests") {
                        popUpTo("tests") {
                            inclusive = true
                        }
                    }
                },
                onBackToTests = {
                    latestTestResult = NavigationTestResult()

                    navController.navigate("tests") {
                        popUpTo("tests") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // ---------------------------------------------------------
        // BOOKMARKS
        // ---------------------------------------------------------
        composable("bookmarks") {
            BookmarksScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        // ---------------------------------------------------------
        // TEST HISTORY
        // ---------------------------------------------------------
        composable("test_history") {
            TestHistoryScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        // ---------------------------------------------------------
        // ACHIEVEMENTS
        // ---------------------------------------------------------
        composable("achievements") {
            AchievementsScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        // ---------------------------------------------------------
        // SETTINGS
        // ---------------------------------------------------------
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
