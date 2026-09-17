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
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(
                onSubjectClick = { subjectId ->
                    navController.navigate(
                        Screen.Chapters.createRoute(
                            subjectId = subjectId,
                            board = Board.MP_BOARD,
                            classLevel = ClassLevel.CLASS_12
                        )
                    )
                }
            )
        }

        composable(Screen.Practice.route) {
            PracticeScreen(
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        composable(Screen.Tests.route) {
            TestScreen(
                subjectId = DEFAULT_TEST_SUBJECT_ID,
                chapterId = DEFAULT_TEST_CHAPTER_ID,
                board = DEFAULT_TEST_BOARD,
                classLevel = DEFAULT_TEST_CLASS,
                onTestFinished = {
                    total,
                    answered,
                    correct,
                    wrong,
                    unattempted,
                    marked
                    ->
                    latestTestResult =
                        NavigationTestResult(
                            total = total,
                            answered = answered,
                            correct = correct,
                            wrong = wrong,
                            unattempted = unattempted,
                            marked = marked
                        )

                    navController.navigate(
                        Screen.TestResult.route
                    )
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.Games.route) {
            GamesScreen()
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                onBookmarks = {
                    navController.navigate(
                        Screen.Bookmarks.route
                    )
                },
                onTestHistory = {
                    navController.navigate(
                        Screen.TestHistory.route
                    )
                },
                onAchievements = {
                    navController.navigate(
                        Screen.Achievements.route
                    )
                },
                onSettings = {
                    navController.navigate(
                        Screen.Settings.route
                    )
                }
            )
        }

        composable(Screen.Subjects.route) {
            SubjectSelectionScreen(
                viewModel = viewModel(),
                onSubjectClick = { subject ->
                    navController.navigate(
                        Screen.Chapters.createRoute(
                            subjectId = subject.id,
                            board = subject.board,
                            classLevel = subject.classLevel
                        )
                    )
                }
            )
        }

        composable(
            route = Screen.Chapters.route
        ) { backStackEntry ->

            val subjectId =
                backStackEntry.arguments
                    ?.getString("subjectId")
                    ?: return@composable

            val board =
                enumValueOrDefault(
                    value =
                        backStackEntry.arguments
                            ?.getString("board")
                            ?: Board.MP_BOARD.name,
                    default = Board.MP_BOARD
                )

            val classLevel =
                enumValueOrDefault(
                    value =
                        backStackEntry.arguments
                            ?.getString("classLevel")
                            ?: ClassLevel.CLASS_12.name,
                    default = ClassLevel.CLASS_12
                )

            val subjectName =
                subjectRepository
                    .getSubjects(
                        board = board,
                        classLevel = classLevel
                    )
                    .firstOrNull {
                        it.id == subjectId
                    }
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
                onChapterClick = {
                    chapterId,
                    _
                    ->
                    navController.navigate(
                        Screen.Questions.createRoute(
                            subjectId = subjectId,
                            chapterId = chapterId,
                            board = board,
                            classLevel = classLevel
                        )
                    )
                }
            )
        }

        composable(
            route = Screen.Questions.route
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
                    value =
                        backStackEntry.arguments
                            ?.getString("board")
                            ?: Board.MP_BOARD.name,
                    default = Board.MP_BOARD
                )

            val classLevel =
                enumValueOrDefault(
                    value =
                        backStackEntry.arguments
                            ?.getString("classLevel")
                            ?: ClassLevel.CLASS_12.name,
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

        composable(Screen.TestResult.route) {
            TestResultScreen(
                total = latestTestResult.total,
                answered = latestTestResult.answered,
                correct = latestTestResult.correct,
                wrong = latestTestResult.wrong,
                unattempted = latestTestResult.unattempted,
                marked = latestTestResult.marked,
                onRestart = {
                    latestTestResult =
                        NavigationTestResult()

                    navController.navigate(
                        Screen.Tests.route
                    ) {
                        popUpTo(
                            Screen.Tests.route
                        ) {
                            inclusive = true
                        }
                    }
                },
                onBackToTests = {
                    latestTestResult =
                        NavigationTestResult()

                    navController.navigate(
                        Screen.Tests.route
                    ) {
                        popUpTo(
                            Screen.Tests.route
                        ) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.Bookmarks.route) {
            BookmarksScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.TestHistory.route) {
            TestHistoryScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.Achievements.route) {
            AchievementsScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

private const val DEFAULT_TEST_SUBJECT_ID =
    "accountancy"

private const val DEFAULT_TEST_CHAPTER_ID =
    "accountancy_class_12_1"

private val DEFAULT_TEST_BOARD =
    Board.MP_BOARD

private val DEFAULT_TEST_CLASS =
    ClassLevel.CLASS_12

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
