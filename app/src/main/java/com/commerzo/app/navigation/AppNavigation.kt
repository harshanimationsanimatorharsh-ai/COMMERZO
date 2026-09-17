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
import com.commerzo.app.ui.screens.TestSelectionScreen

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

    val subjectRepository =
        remember {
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

        /*
         * TEST SELECTION
         *
         * The Tests tab now opens the selection screen
         * instead of starting a hardcoded test.
         */
        composable(Screen.Tests.route) {
            TestSelectionScreen(
                onStartTest = {
                    subjectId,
                    chapterId,
                    board,
                    classLevel ->

                    navController.navigate(
                        Screen.TestSession.createRoute(
                            subjectId = subjectId,
                            chapterId = chapterId,
                            board = board,
                            classLevel = classLevel
                        )
                    )
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        /*
         * ACTUAL TEST SESSION
         *
         * Receives the selected curriculum from TestSelectionScreen.
         */
        composable(Screen.TestSession.route) { backStackEntry ->

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
                    backStackEntry.arguments
                        ?.getString("board")
                        ?: Board.MP_BOARD.name,
                    Board.MP_BOARD
                )

            val classLevel =
                enumValueOrDefault(
                    backStackEntry.arguments
                        ?.getString("classLevel")
                        ?: ClassLevel.CLASS_12.name,
                    ClassLevel.CLASS_12
                )

            TestScreen(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                onTestFinished = {
                    total,
                    answered,
                    correct,
                    wrong,
                    unattempted,
                    marked ->

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
                            subject.id,
                            subject.board,
                            subject.classLevel
                        )
                    )
                }
            )
        }

        composable(Screen.Chapters.route) { backStackEntry ->

            val subjectId =
                backStackEntry.arguments
                    ?.getString("subjectId")
                    ?: return@composable

            val board =
                enumValueOrDefault(
                    backStackEntry.arguments
                        ?.getString("board")
                        ?: Board.MP_BOARD.name,
                    Board.MP_BOARD
                )

            val classLevel =
                enumValueOrDefault(
                    backStackEntry.arguments
                        ?.getString("classLevel")
                        ?: ClassLevel.CLASS_12.name,
                    ClassLevel.CLASS_12
                )

            val subjectName =
                subjectRepository
                    .getSubjects(
                        board,
                        classLevel
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
                    _ ->

                    navController.navigate(
                        Screen.Questions.createRoute(
                            subjectId,
                            chapterId,
                            board,
                            classLevel
                        )
                    )
                }
            )
        }

        composable(Screen.Questions.route) { backStackEntry ->

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
                    backStackEntry.arguments
                        ?.getString("board")
                        ?: Board.MP_BOARD.name,
                    Board.MP_BOARD
                )

            val classLevel =
                enumValueOrDefault(
                    backStackEntry.arguments
                        ?.getString("classLevel")
                        ?: ClassLevel.CLASS_12.name,
                    ClassLevel.CLASS_12
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
                total =
                    latestTestResult.total,
                answered =
                    latestTestResult.answered,
                correct =
                    latestTestResult.correct,
                wrong =
                    latestTestResult.wrong,
                unattempted =
                    latestTestResult.unattempted,
                marked =
                    latestTestResult.marked,

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

private inline fun <reified T : Enum<T>>
    enumValueOrDefault(
        value: String,
        default: T
    ): T =
    try {
        enumValueOf<T>(value)
    } catch (
        _: IllegalArgumentException
    ) {
        default
    }
