package com.commerzo.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.commerzo.app.ui.components.CommerzoBottomBar
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

@Composable
fun AppNavigation() {

    val navController =
        rememberNavController()

    Scaffold(

        bottomBar = {
            CommerzoBottomBar(navController)
        }

    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier =
                Modifier.padding(paddingValues)
        ) {

            composable(Screen.Home.route) {

                HomeScreen(
                    onSubjectClick = { subjectId ->

                        navController.navigate(
                            Screen.Chapters
                                .createRoute(subjectId)
                        )
                    }
                )
            }

            composable(Screen.Practice.route) {
                PracticeScreen()
            }

            composable(Screen.Tests.route) {

                TestsScreen(
                    onStartTest = {
                            subjectId,
                            chapterId ->

                        navController.navigate(
                            Screen.Test.createRoute(
                                subjectId,
                                chapterId
                            )
                        )
                    }
                )
            }

            composable(Screen.Games.route) {
                GamesScreen()
            }

            composable(Screen.Profile.route) {
                ProfileScreen()
            }

            composable(
                Screen.SubjectSelection.route
            ) {

                SubjectSelectionScreen(
                    onSubjectClick = { subjectId ->

                        navController.navigate(
                            Screen.Chapters
                                .createRoute(subjectId)
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

            ) { entry ->

                val subjectId =
                    entry.arguments
                        ?.getString("subjectId")
                        ?: return@composable

                ChapterScreen(

                    subjectId = subjectId,

                    onBack = {
                        navController.popBackStack()
                    },

                    onChapterClick = { chapterId ->

                        navController.navigate(
                            Screen.Questions
                                .createRoute(
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

            ) { entry ->

                val subjectId =
                    entry.arguments
                        ?.getString("subjectId")
                        ?: return@composable

                val chapterId =
                    entry.arguments
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

            ) { entry ->

                val subjectId =
                    entry.arguments
                        ?.getString("subjectId")
                        ?: return@composable

                val chapterId =
                    entry.arguments
                        ?.getString("chapterId")
                        ?: return@composable

                TestScreen(

                    subjectId = subjectId,
                    chapterId = chapterId,

                    onBack = {
                        navController.popBackStack()
                    },

                    onTestFinished = {
                            total,
                            answered,
                            correct,
                            wrong,
                            unattempted,
                            marked ->

                        navController.navigate(
                            "test_result/$total/$answered/$correct/$wrong/$unattempted/$marked"
                        ) {

                            popUpTo(
                                Screen.Test.route
                            ) {
                                inclusive = true
                            }
                        }
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

            ) { entry ->

                val total =
                    entry.arguments
                        ?.getInt("total") ?: 0

                val answered =
                    entry.arguments
                        ?.getInt("answered") ?: 0

                val correct =
                    entry.arguments
                        ?.getInt("correct") ?: 0

                val wrong =
                    entry.arguments
                        ?.getInt("wrong") ?: 0

                val unattempted =
                    entry.arguments
                        ?.getInt("unattempted") ?: 0

                val marked =
                    entry.arguments
                        ?.getInt("marked") ?: 0

                TestResultScreen(

                    total = total,
                    answered = answered,
                    correct = correct,
                    wrong = wrong,
                    unattempted = unattempted,
                    marked = marked,

                    onRestart = {
                        navController.popBackStack()
                    },

                    onBackToTests = {

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

            composable(
                route = "test_history"
            ) {

                TestHistoryScreen()
            }
        }
    }
}
