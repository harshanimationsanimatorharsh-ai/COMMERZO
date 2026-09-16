package com.commerzo.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.commerzo.app.data.repository.TestHistoryRepository
import com.commerzo.app.ui.components.CommerzoBottomBar
import com.commerzo.app.ui.screens.ChapterScreen
import com.commerzo.app.ui.screens.GamesScreen
import com.commerzo.app.ui.screens.HomeScreen
import com.commerzo.app.ui.screens.PracticeResultScreen
import com.commerzo.app.ui.screens.PracticeScreen
import com.commerzo.app.ui.screens.ProfileScreen
import com.commerzo.app.ui.screens.QuestionScreen
import com.commerzo.app.ui.screens.SubjectSelectionScreen
import com.commerzo.app.ui.screens.TestHistoryScreen
import com.commerzo.app.ui.screens.TestResultScreen
import com.commerzo.app.ui.screens.TestScreen
import com.commerzo.app.ui.screens.TestsScreen

@Composable
fun AppNavigation() {

    val navController =
        rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(
            route = Screen.Home.route
        ) {

            HomeScreen(
                onSubjectClick = { subjectId ->
                    navController.navigate(
                        Screen.Chapters.createRoute(
                            subjectId
                        )
                    )
                }
            )
        }

        composable(
            route = Screen.Practice.route
        ) {

            PracticeScreen()
        }

        composable(
            route = Screen.Tests.route
        ) {

            TestsScreen(
                onStartTest = { subjectId, chapterId ->

                    navController.navigate(
                        Screen.Test.createRoute(
                            subjectId,
                            chapterId
                        )
                    )
                },

                onOpenHistory = {

                    navController.navigate(
                        "test_history"
                    )
                }
            )
        }

        composable(
            route = Screen.Games.route
        ) {

            GamesScreen()
        }

        composable(
            route = Screen.Profile.route
        ) {

            ProfileScreen()
        }

        composable(
            route = Screen.SubjectSelection.route
        ) {

            SubjectSelectionScreen()
        }

        composable(
            route = Screen.Chapters.route,
            arguments = listOf(
                navArgument("subjectId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val subjectId =
                backStackEntry.arguments
                    ?.getString("subjectId")
                    ?: return@composable

            ChapterScreen(
                subjectId = subjectId,
                onChapterClick = { chapterId ->

                    navController.navigate(
                        Screen.Questions.createRoute(
                            subjectId,
                            chapterId
                        )
                    )
                }
            )
        }

        composable(
            route = Screen.Questions.route,
            arguments = listOf(
                navArgument("subjectId") {
                    type = NavType.StringType
                },
                navArgument("chapterId") {
                    type = NavType.StringType
                }
            )
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

        composable(
            route = Screen.Test.route,
            arguments = listOf(
                navArgument("subjectId") {
                    type = NavType.StringType
                },
                navArgument("chapterId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val subjectId =
                backStackEntry.arguments
                    ?.getString("subjectId")
                    ?: return@composable

            val chapterId =
                backStackEntry.arguments
                    ?.getString("chapterId")
                    ?: return@composable

            TestScreen(
                subjectId = subjectId,
                chapterId = chapterId,

                onTestFinished = {
                    total,
                    answered,
                    correct,
                    wrong,
                    unattempted,
                    marked ->

                    TestHistoryRepository.saveTest(
                        subjectId = subjectId,
                        chapterId = chapterId,
                        totalQuestions = total,
                        answered = answered,
                        correct = correct,
                        wrong = wrong,
                        unattempted = unattempted,
                        marked = marked
                    )

                    navController.navigate(
                        "test_result/$total/$answered/$correct/$wrong/$unattempted/$marked"
                    )
                },

                onExit = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route =
                "test_result/{total}/{answered}/{correct}/{wrong}/{unattempted}/{marked}",
            arguments = listOf(
                navArgument("total") {
                    type = NavType.IntType
                },
                navArgument("answered") {
                    type = NavType.IntType
                },
                navArgument("correct") {
                    type = NavType.IntType
                },
                navArgument("wrong") {
                    type = NavType.IntType
                },
                navArgument("unattempted") {
                    type = NavType.IntType
                },
                navArgument("marked") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val total =
                backStackEntry.arguments
                    ?.getInt("total")
                    ?: 0

            val answered =
                backStackEntry.arguments
                    ?.getInt("answered")
                    ?: 0

            val correct =
                backStackEntry.arguments
                    ?.getInt("correct")
                    ?: 0

            val wrong =
                backStackEntry.arguments
                    ?.getInt("wrong")
                    ?: 0

            val unattempted =
                backStackEntry.arguments
                    ?.getInt("unattempted")
                    ?: 0

            val marked =
                backStackEntry.arguments
                    ?.getInt("marked")
                    ?: 0

            TestResultScreen(
                total = total,
                answered = answered,
                correct = correct,
                wrong = wrong,
                unattempted = unattempted,
                marked = marked,

                onRestart = {
                    navController.popBackStack(
                        Screen.Test.route,
                        inclusive = false
                    )
                },

                onBackToTests = {

                    navController.navigate(
                        Screen.Tests.route
                    ) {
                        popUpTo(
                            Screen.Tests.route
                        ) {
                            inclusive = false
                        }
                    }
                }
            )
        }

        composable(
            route = "test_history"
        ) {

            TestHistoryScreen()
        }
    }
}
