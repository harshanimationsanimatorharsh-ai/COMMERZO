package com.commerzo.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.commerzo.app.ui.screens.ChapterScreen
import com.commerzo.app.ui.screens.GamesScreen
import com.commerzo.app.ui.screens.HomeScreen
import com.commerzo.app.ui.screens.PracticeScreen
import com.commerzo.app.ui.screens.ProfileScreen
import com.commerzo.app.ui.screens.QuestionScreen
import com.commerzo.app.ui.screens.SubjectSelectionScreen
import com.commerzo.app.ui.screens.TestHistoryScreen
import com.commerzo.app.ui.screens.TestResultScreen
import com.commerzo.app.ui.screens.TestScreen
import com.commerzo.app.ui.screens.TestsScreen
import com.commerzo.app.ui.screens.WelcomeScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {

        composable("welcome") {
            WelcomeScreen()

            androidx.compose.runtime.LaunchedEffect(Unit) {
                kotlinx.coroutines.delay(2500)

                navController.navigate(Screen.Home.route) {
                    popUpTo("welcome") {
                        inclusive = true
                    }
                }
            }
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onSubjectClick = { subjectId ->
                    navController.navigate(
                        Screen.Chapters.createRoute(subjectId)
                    )
                }
            )
        }

        composable(Screen.Practice.route) {
            PracticeScreen()
        }

        composable(Screen.Tests.route) {
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
                    navController.navigate("test_history")
                }
            )
        }

        composable(Screen.Games.route) {
            GamesScreen()
        }

        composable(Screen.Profile.route) {
            ProfileScreen()
        }

        composable(Screen.SubjectSelection.route) {
            SubjectSelectionScreen(
                onSubjectClick = { subjectId ->
                    navController.navigate(
                        Screen.Chapters.createRoute(subjectId)
                    )
                }
            )
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
                backStackEntry.arguments?.getString("subjectId")
                    ?: return@composable

            ChapterScreen(
                subjectId = subjectId,
                onBack = {
                    navController.popBackStack()
                },
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
                backStackEntry.arguments?.getString("subjectId")
                    ?: return@composable

            val chapterId =
                backStackEntry.arguments?.getString("chapterId")
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
                backStackEntry.arguments?.getString("subjectId")
                    ?: return@composable

            val chapterId =
                backStackEntry.arguments?.getString("chapterId")
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

                    navController.navigate(
                        "test_result/$subjectId/$chapterId/$total/$answered/$correct/$wrong/$unattempted/$marked"
                    )
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "test_result/{subjectId}/{chapterId}/{total}/{answered}/{correct}/{wrong}/{unattempted}/{marked}",
            arguments = listOf(
                navArgument("subjectId") {
                    type = NavType.StringType
                },
                navArgument("chapterId") {
                    type = NavType.StringType
                },
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

            val subjectId =
                backStackEntry.arguments?.getString("subjectId")
                    ?: return@composable

            val chapterId =
                backStackEntry.arguments?.getString("chapterId")
                    ?: return@composable

            val total =
                backStackEntry.arguments?.getInt("total") ?: 0

            val answered =
                backStackEntry.arguments?.getInt("answered") ?: 0

            val correct =
                backStackEntry.arguments?.getInt("correct") ?: 0

            val wrong =
                backStackEntry.arguments?.getInt("wrong") ?: 0

            val unattempted =
                backStackEntry.arguments?.getInt("unattempted") ?: 0

            val marked =
                backStackEntry.arguments?.getInt("marked") ?: 0

            TestResultScreen(
                total = total,
                answered = answered,
                correct = correct,
                wrong = wrong,
                unattempted = unattempted,
                marked = marked,
                onRestart = {

                    navController.navigate(
                        Screen.Test.createRoute(
                            subjectId,
                            chapterId
                        )
                    ) {
                        popUpTo(
                            "test_result/$subjectId/$chapterId/$total/$answered/$correct/$wrong/$unattempted/$marked"
                        ) {
                            inclusive = true
                        }
                    }
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

        composable("test_history") {
            TestHistoryScreen()
        }
    }
}
