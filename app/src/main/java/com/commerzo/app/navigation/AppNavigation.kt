package com.commerzo.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.ui.components.CommerzoBottomBar
import com.commerzo.app.ui.screens.ChapterScreen
import com.commerzo.app.ui.screens.GamesScreen
import com.commerzo.app.ui.screens.HomeScreen
import com.commerzo.app.ui.screens.PracticeScreen
import com.commerzo.app.ui.screens.ProfileScreen
import com.commerzo.app.ui.screens.QuestionScreen
import com.commerzo.app.ui.screens.SubjectSelectionScreen
import com.commerzo.app.ui.screens.TestResultScreen
import com.commerzo.app.ui.screens.TestScreen
import com.commerzo.app.ui.screens.TestsScreen
import com.commerzo.app.viewmodel.HomeViewModel
import com.commerzo.app.viewmodel.SubjectSelectionViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val homeViewModel: HomeViewModel = viewModel()
    val subjectSelectionViewModel: SubjectSelectionViewModel = viewModel()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val showBottomBar = currentRoute in listOf(
        "home",
        "practice",
        "tests",
        "games",
        "profile"
    )

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                CommerzoBottomBar(
                    currentRoute = currentRoute,
                    onNavigate = { route ->
                        navController.navigate(route) {
                            popUpTo("home") {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {

            composable("home") {
                HomeScreen(
                    viewModel = homeViewModel,
                    onSubjectClick = { subject ->
                        navController.navigate(
                            "chapters/${subject.id}/${subject.name}/${subject.board.name}/${subject.classLevel.name}"
                        )
                    }
                )
            }

            composable("practice") {
                PracticeScreen(
                    onSubjectClick = {
                        navController.navigate("subjects")
                    }
                )
            }

            composable("tests") {
                TestsScreen(
                    onSubjectClick = {
                        navController.navigate("subjects")
                    }
                )
            }

            composable("games") {
                GamesScreen()
            }

            composable("profile") {
                ProfileScreen()
            }

            composable("subjects") {
                SubjectSelectionScreen(
                    viewModel = subjectSelectionViewModel,
                    onSubjectClick = { subject ->
                        navController.navigate(
                            "chapters/${subject.id}/${subject.name}/${subject.board.name}/${subject.classLevel.name}"
                        )
                    }
                )
            }

            composable(
                route = "chapters/{subjectId}/{subjectName}/{board}/{classLevel}",
                arguments = listOf(
                    navArgument("subjectId") {
                        type = NavType.StringType
                    },
                    navArgument("subjectName") {
                        type = NavType.StringType
                    },
                    navArgument("board") {
                        type = NavType.StringType
                    },
                    navArgument("classLevel") {
                        type = NavType.StringType
                    }
                )
            ) { entry ->

                val subjectId =
                    entry.arguments?.getString("subjectId") ?: return@composable

                val subjectName =
                    entry.arguments?.getString("subjectName") ?: return@composable

                val board = runCatching {
                    Board.valueOf(
                        entry.arguments?.getString("board")
                            ?: Board.MP_BOARD.name
                    )
                }.getOrDefault(Board.MP_BOARD)

                val classLevel = runCatching {
                    ClassLevel.valueOf(
                        entry.arguments?.getString("classLevel")
                            ?: ClassLevel.CLASS_12.name
                    )
                }.getOrDefault(ClassLevel.CLASS_12)

                ChapterScreen(
                    subjectId = subjectId,
                    subjectName = subjectName,
                    board = board,
                    classLevel = classLevel,
                    onBack = {
                        navController.popBackStack()
                    },
                    onChapterClick = { chapterId, chapterTitle ->
                        navController.navigate(
                            "questions/$subjectId/$chapterId/$chapterTitle"
                        )
                    }
                )
            }

            composable(
                route = "questions/{subjectId}/{chapterId}/{chapterTitle}",
                arguments = listOf(
                    navArgument("subjectId") {
                        type = NavType.StringType
                    },
                    navArgument("chapterId") {
                        type = NavType.StringType
                    },
                    navArgument("chapterTitle") {
                        type = NavType.StringType
                    }
                )
            ) { entry ->

                val subjectId =
                    entry.arguments?.getString("subjectId") ?: return@composable

                val chapterId =
                    entry.arguments?.getString("chapterId") ?: return@composable

                QuestionScreen(
                    subjectId = subjectId,
                    chapterId = chapterId,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }

            composable(
                route = "test/{subjectId}/{chapterId}",
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
                    entry.arguments?.getString("subjectId") ?: return@composable

                val chapterId =
                    entry.arguments?.getString("chapterId") ?: return@composable

                TestScreen(
                    subjectId = subjectId,
                    chapterId = chapterId,
                    onFinish = {
                        navController.navigate(
                            "test_result/$subjectId/$chapterId"
                        ) {
                            popUpTo("test/$subjectId/$chapterId") {
                                inclusive = true
                            }
                        }
                    },
                    onExit = {
                        navController.popBackStack()
                    }
                )
            }

            composable(
                route = "test_result/{subjectId}/{chapterId}",
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
                    entry.arguments?.getString("subjectId") ?: return@composable

                val chapterId =
                    entry.arguments?.getString("chapterId") ?: return@composable

                TestResultScreen(
                    onRestart = {
                        navController.navigate(
                            "test/$subjectId/$chapterId"
                        )
                    },
                    onBackToTests = {
                        navController.navigate("tests") {
                            popUpTo("home") {
                                inclusive = false
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}
