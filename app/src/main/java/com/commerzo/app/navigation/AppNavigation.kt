package com.commerzo.app.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.content.CurriculumContentIds
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
import com.commerzo.app.ui.screens.StudyTrackerScreen
import com.commerzo.app.ui.screens.SubjectSelectionScreen
import com.commerzo.app.ui.screens.TestHistoryScreen
import com.commerzo.app.ui.screens.TestResultScreen
import com.commerzo.app.ui.screens.TestScreen
import com.commerzo.app.ui.screens.TestSelectionScreen
import com.commerzo.app.ui.viewmodel.auth.AuthViewModel

data class NavigationTestResult(
    val total: Int = 0,
    val answered: Int = 0,
    val correct: Int = 0,
    val wrong: Int = 0,
    val unattempted: Int = 0,
    val marked: Int = 0
)

private data class BottomNavItem(
    val route: String,
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

/**
 * COMMERZO root navigation.
 *
 * Final target bottom navigation:
 *
 * HOME | PRACTICE | TESTS | PROFILE
 *
 * Subjects/Learn and Games remain available as internal destinations
 * for compatibility, but they are intentionally NOT root bottom tabs.
 */
private val bottomNavItems = listOf(
    BottomNavItem(
        route = Screen.Home.route,
        label = "Home",
        icon = Icons.Default.Home
    ),
    BottomNavItem(
        route = Screen.Practice.route,
        label = "Practice",
        icon = Icons.Default.PlayCircle
    ),
    BottomNavItem(
        route = Screen.Tests.route,
        label = "Tests",
        icon = Icons.Default.Assignment
    ),
    BottomNavItem(
        route = Screen.Profile.route,
        label = "Profile",
        icon = Icons.Default.Person
    )
)

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    authViewModel: AuthViewModel = viewModel()
) {
    var latestTestResult by remember {
        mutableStateOf(NavigationTestResult())
    }

    val currentBackStackEntry by
        navController.currentBackStackEntryAsState()

    val currentRoute =
        currentBackStackEntry?.destination?.route

    val subjectRepository =
        remember {
            SubjectRepository()
        }

    val showBottomBar =
        bottomNavItems.any { item ->
            item.route == currentRoute
        }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface
                ) {
                    bottomNavItems.forEach { item ->

                        val selected =
                            currentRoute == item.route

                        NavigationBarItem(
                            selected = selected,
                            onClick = {

                                if (!selected) {
                                    navController.navigate(
                                        item.route
                                    ) {
                                        popUpTo(
                                            Screen.Home.route
                                        ) {
                                            saveState = true
                                        }

                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.label
                                )
                            },
                            label = {
                                Text(
                                    text = item.label
                                )
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->

        Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .padding(
                    if (showBottomBar) {
                        innerPadding
                    } else {
                        PaddingValues()
                    }
                )
        ) {

            NavHost(
                navController = navController,
                startDestination = Screen.Home.route
            ) {

                // ─────────────────────────────────────────────────
                // HOME
                // ─────────────────────────────────────────────────

                composable(Screen.Home.route) {
                    HomeScreen(
                        onSubjectClick = { subjectId ->
                            navController.navigate(
                                Screen.Chapters.createRoute(
                                    subjectId = subjectId,
                                    board = Board.MP_BOARD.name,
                                    classLevel = ClassLevel.CLASS_12.name
                                )
                            )
                        },
                        onSubjectsClick = {
                            navController.navigate(
                                Screen.Subjects.route
                            )
                        },
                        onPracticeClick = {
                            navController.navigate(
                                Screen.Practice.route
                            )
                        },
                        onTestsClick = {
                            navController.navigate(
                                Screen.Tests.route
                            )
                        },
                        onGamesClick = {
                            navController.navigate(
                                Screen.Games.route
                            )
                        },
                        onProfileClick = {
                            navController.navigate(
                                Screen.Profile.route
                            )
                        },
                        onBookmarksClick = {
                            navController.navigate(
                                Screen.Bookmarks.route
                            )
                        },
                        onTestHistoryClick = {
                            navController.navigate(
                                Screen.TestHistory.route
                            )
                        },
                        onAchievementsClick = {
                            navController.navigate(
                                Screen.Achievements.route
                            )
                        },
                        onSettingsClick = {
                            navController.navigate(
                                Screen.Settings.route
                            )
                        }
                    )
                }

                // ─────────────────────────────────────────────────
                // PRACTICE
                // ─────────────────────────────────────────────────

                composable(Screen.Practice.route) {
                    PracticeScreen(
                        onNavigate = { route ->
                            navController.navigate(route)
                        }
                    )
                }

                // ─────────────────────────────────────────────────
                // TEST CENTER
                // ─────────────────────────────────────────────────

                composable(Screen.Tests.route) {
                    TestSelectionScreen(
                        onStartTest = {
                            subjectId,
                            chapterId,
                            board,
                            classLevel ->

                            navController.navigate(
                                Screen.TestSession.createRoute(
                                    subjectId = toQuestionSubjectId(
                                        subjectId
                                    ),
                                    chapterId = chapterId,
                                    board = board.name,
                                    classLevel = classLevel.name
                                )
                            )
                        },
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                // ─────────────────────────────────────────────────
                // TEST SESSION
                // ─────────────────────────────────────────────────

                composable(Screen.TestSession.route) { backStackEntry ->

                    val rawSubjectId =
                        backStackEntry.arguments
                            ?.getString("subjectId")
                            ?: return@composable

                    val subjectId =
                        toQuestionSubjectId(
                            rawSubjectId
                        )

                    val chapterId =
                        backStackEntry.arguments
                            ?.getString("chapterId")
                            ?: return@composable

                    val board =
                        enumValueOrDefault(
                            decodeRouteArgument(
                                backStackEntry.arguments
                                    ?.getString("board")
                            ),
                            Board.MP_BOARD
                        )

                    val classLevel =
                        enumValueOrDefault(
                            decodeRouteArgument(
                                backStackEntry.arguments
                                    ?.getString("classLevel")
                            ),
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

                // ─────────────────────────────────────────────────
                // GAMES
                //
                // Internal destination only.
                // NOT a bottom-navigation destination.
                // ─────────────────────────────────────────────────

                composable(Screen.Games.route) {
                    GamesScreen()
                }

                // ─────────────────────────────────────────────────
                // PROFILE
                // ─────────────────────────────────────────────────

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
                        },
                        onStudyTracker = {
                            navController.navigate(
                                Screen.StudyTracker.route
                            )
                        },
                        onLogout = {
                            authViewModel.signOut()
                        }
                    )
                }

                // ─────────────────────────────────────────────────
                // STUDY TRACKER
                // ─────────────────────────────────────────────────

                composable(Screen.StudyTracker.route) {
                    StudyTrackerScreen(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                composable(
                    Screen.StudyTrackerSession.route
                ) { backStackEntry ->

                    val subjectId =
                        decodeRouteArgument(
                            backStackEntry.arguments
                                ?.getString("subjectId")
                        ).takeIf { it.isNotBlank() }
                            ?: return@composable

                    val chapterId =
                        decodeRouteArgument(
                            backStackEntry.arguments
                                ?.getString("chapterId")
                        ).takeIf { it.isNotBlank() }
                            ?: return@composable

                    val board =
                        decodeRouteArgument(
                            backStackEntry.arguments
                                ?.getString("board")
                        ).takeIf { it.isNotBlank() }
                            ?: return@composable

                    val classLevel =
                        decodeRouteArgument(
                            backStackEntry.arguments
                                ?.getString("classLevel")
                        ).takeIf { it.isNotBlank() }
                            ?: return@composable

                    StudyTrackerScreen(
                        subjectId = subjectId,
                        chapterId = chapterId,
                        board = board,
                        classLevel = classLevel,
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                // ─────────────────────────────────────────────────
                // SUBJECTS / LEARNING
                //
                // Internal destination.
                // NOT a bottom-navigation destination.
                // ─────────────────────────────────────────────────

                composable(Screen.Subjects.route) {
                    SubjectSelectionScreen(
                        viewModel = viewModel(),
                        onSubjectClick = { subject ->

                            navController.navigate(
                                Screen.Chapters.createRoute(
                                    subjectId = subject.id,
                                    board = subject.board.name,
                                    classLevel = subject.classLevel.name
                                )
                            )
                        }
                    )
                }

                // ─────────────────────────────────────────────────
                // CHAPTERS
                // ─────────────────────────────────────────────────

                composable(Screen.Chapters.route) { backStackEntry ->

                    val subjectId =
                        decodeRouteArgument(
                            backStackEntry.arguments
                                ?.getString("subjectId")
                        ).takeIf { it.isNotBlank() }
                            ?: return@composable

                    val board =
                        enumValueOrDefault(
                            decodeRouteArgument(
                                backStackEntry.arguments
                                    ?.getString("board")
                            ),
                            Board.MP_BOARD
                        )

                    val classLevel =
                        enumValueOrDefault(
                            decodeRouteArgument(
                                backStackEntry.arguments
                                    ?.getString("classLevel")
                            ),
                            ClassLevel.CLASS_12
                        )

                    val subjectName =
                        getSubjectDisplayName(
                            subjectRepository = subjectRepository,
                            subjectId = subjectId,
                            board = board,
                            classLevel = classLevel
                        )

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
                                    subjectId =
                                        toQuestionSubjectId(
                                            subjectId
                                        ),
                                    chapterId = chapterId,
                                    board = board.name,
                                    classLevel = classLevel.name
                                )
                            )
                        },
                        onStartStudy = {
                            startSubjectId,
                            startChapterId,
                            startBoard,
                            startClassLevel,
                            _ ->

                            navController.navigate(
                                Screen.StudyTrackerSession.createRoute(
                                    subjectId = startSubjectId,
                                    chapterId = startChapterId,
                                    board = startBoard,
                                    classLevel = startClassLevel
                                )
                            )
                        }
                    )
                }

                // ─────────────────────────────────────────────────
                // QUESTIONS
                // ─────────────────────────────────────────────────

                composable(Screen.Questions.route) { backStackEntry ->

                    val rawSubjectId =
                        decodeRouteArgument(
                            backStackEntry.arguments
                                ?.getString("subjectId")
                        ).takeIf { it.isNotBlank() }
                            ?: return@composable

                    val subjectId =
                        toQuestionSubjectId(
                            rawSubjectId
                        )

                    val chapterId =
                        decodeRouteArgument(
                            backStackEntry.arguments
                                ?.getString("chapterId")
                        ).takeIf { it.isNotBlank() }
                            ?: return@composable

                    val board =
                        enumValueOrDefault(
                            decodeRouteArgument(
                                backStackEntry.arguments
                                    ?.getString("board")
                            ),
                            Board.MP_BOARD
                        )

                    val classLevel =
                        enumValueOrDefault(
                            decodeRouteArgument(
                                backStackEntry.arguments
                                    ?.getString("classLevel")
                            ),
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

                // ─────────────────────────────────────────────────
                // TEST RESULT
                // ─────────────────────────────────────────────────

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

                // ─────────────────────────────────────────────────
                // BOOKMARKS
                // ─────────────────────────────────────────────────

                composable(Screen.Bookmarks.route) {
                    BookmarksScreen(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                // ─────────────────────────────────────────────────
                // TEST HISTORY
                // ─────────────────────────────────────────────────

                composable(Screen.TestHistory.route) {
                    TestHistoryScreen(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                // ─────────────────────────────────────────────────
                // ACHIEVEMENTS
                // ─────────────────────────────────────────────────

                composable(Screen.Achievements.route) {
                    AchievementsScreen(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }

                // ─────────────────────────────────────────────────
                // SETTINGS
                // ─────────────────────────────────────────────────

                composable(Screen.Settings.route) {
                    SettingsScreen(
                        onBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}

private fun toQuestionSubjectId(
    subjectId: String
): String {
    return when (subjectId) {

        CurriculumContentIds.MP_BOARD_CLASS_12_ECONOMICS_MICRO,
        CurriculumContentIds.MP_BOARD_CLASS_12_ECONOMICS_MACRO,
        CurriculumContentIds.CBSE_CLASS_12_ECONOMICS_INDIAN,
        CurriculumContentIds.CBSE_CLASS_12_ECONOMICS_MACRO -> {
            "economics"
        }

        else -> subjectId
    }
}

private fun getSubjectDisplayName(
    subjectRepository: SubjectRepository,
    subjectId: String,
    board: Board,
    classLevel: ClassLevel
): String {

    return when (subjectId) {

        CurriculumContentIds.MP_BOARD_CLASS_12_ECONOMICS_MICRO ->
            "Economics • Micro Economics"

        CurriculumContentIds.MP_BOARD_CLASS_12_ECONOMICS_MACRO ->
            "Economics • Macro Economics"

        CurriculumContentIds.CBSE_CLASS_12_ECONOMICS_INDIAN ->
            "Economics • Indian Economic Development"

        CurriculumContentIds.CBSE_CLASS_12_ECONOMICS_MACRO ->
            "Economics • Macroeconomics"

        else ->
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
    }
}

private inline fun <reified T : Enum<T>>
    enumValueOrDefault(
        value: String,
        default: T
    ): T =
    try {
        enumValueOf<T>(value)
    } catch (_: IllegalArgumentException) {
        default
    }

private fun decodeRouteArgument(
    value: String?
): String {
    if (value.isNullOrBlank()) {
        return ""
    }

    return try {
        java.net.URLDecoder.decode(
            value,
            Charsets.UTF_8.name()
        )
    } catch (_: IllegalArgumentException) {
        value
    }
}
