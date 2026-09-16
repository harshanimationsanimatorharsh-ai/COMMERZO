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
import com.commerzo.app.ui.screens.TestsScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            CommerzoBottomBar(navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {

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

                TestsScreen()
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
                    backStackEntry.arguments
                        ?.getString("subjectId")
                        ?: return@composable

                ChapterScreen(
                    subjectId = subjectId,
                    onBack = {
                        navController.popBackStack()
                    },
                    onChapterClick = { chapterId ->

                        navController.navigate(
                            Screen.Questions.createRoute(
                                subjectId = subjectId,
                                chapterId = chapterId
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
        }
    }
}
