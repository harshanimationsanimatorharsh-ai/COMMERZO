package com.commerzo.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import com.commerzo.app.data.model.auth.AuthState
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
import com.commerzo.app.ui.screens.SubjectSelectionScreen
import com.commerzo.app.ui.screens.TestHistoryScreen
import com.commerzo.app.ui.screens.TestResultScreen
import com.commerzo.app.ui.screens.TestScreen
import com.commerzo.app.ui.screens.TestSelectionScreen
import com.commerzo.app.ui.screens.auth.CreateAccountScreen
import com.commerzo.app.ui.screens.auth.LoginScreen
import com.commerzo.app.ui.viewmodel.auth.AuthViewModel

private object AuthRoutes {
    const val LOGIN = "auth_login"
    const val CREATE_ACCOUNT = "auth_create_account"
}

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
    navController: NavHostController = rememberNavController(),
    authViewModel: AuthViewModel = viewModel()
) {
    var latestTestResult by remember {
        mutableStateOf(NavigationTestResult())
    }

    val authState by authViewModel.authState.collectAsState()

    val currentBackStackEntry by
        navController.currentBackStackEntryAsState()

    val currentRoute =
        currentBackStackEntry?.destination?.route

    val subjectRepository =
        remember {
            SubjectRepository()
        }

    LaunchedEffect(authState) {
        when (authState) {

            is AuthState.LoggedIn -> {
                if (
                    currentRoute == AuthRoutes.LOGIN ||
                    currentRoute == AuthRoutes.CREATE_ACCOUNT ||
                    currentRoute == null
                ) {
                    navController.navigate(
                        Screen.Home.route
                    ) {
                        popUpTo(
                            AuthRoutes.LOGIN
                        ) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            }

            is AuthState.LoggedOut -> {
                if (
                    currentRoute != AuthRoutes.LOGIN &&
                    currentRoute != AuthRoutes.CREATE_ACCOUNT
                ) {
                    navController.navigate(
                        AuthRoutes.LOGIN
                    ) {
                        popUpTo(
                            Screen.Home.route
                        ) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            }

            is AuthState.Loading -> {
                // Keep the current destination while authentication resolves.
            }

            is AuthState.PhoneOtpSent -> {
                // OTP is handled inside LoginScreen.
                // Navigation must remain on the authentication screen.
            }

            is AuthState.Error -> {
                // Authentication screens display their own errors.
            }
        }
    }

    val initialDestination =
        if (authState is AuthState.LoggedIn) {
            Screen.Home.route
        } else {
            AuthRoutes.LOGIN
        }

    NavHost(
        navController = navController,
        startDestination = initialDestination
    ) {

        composable(AuthRoutes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(
                        Screen.Home.route
                    ) {
                        popUpTo(
                            AuthRoutes.LOGIN
                        ) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onCreateAccount = {
                    navController.navigate(
                        AuthRoutes.CREATE_ACCOUNT
                    )
                }
            )
        }

        composable(AuthRoutes.CREATE_ACCOUNT) {
            CreateAccountScreen(
                onBack = {
                    navController.popBackStack()
                },
                onAccountCreated = {
                    navController.navigate(
                        Screen.Home.route
                    ) {
                        popUpTo(
                            AuthRoutes.CREATE_ACCOUNT
                        ) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

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

        composable(Screen.Practice.route) {
            PracticeScreen(
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        composable(Screen.Tests.route) {
            TestSelectionScreen(
                onStartTest = {
                    subjectId,
                    chapterId,
                    board,
                    classLevel ->

                    navController.navigate(
                        Screen.TestSession.createRoute(
                            subjectId = toQuestionSubjectId(subjectId),
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

        composable(Screen.TestSession.route) { backStackEntry ->

            val rawSubjectId =
                backStackEntry.arguments
                    ?.getString("subjectId")
                    ?: return@composable

            val subjectId =
                toQuestionSubjectId(rawSubjectId)

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
                            board = board,
                            classLevel = classLevel
                        )
                    )
                }
            )
        }

        composable(Screen.Questions.route) { backStackEntry ->

            val rawSubjectId =
                backStackEntry.arguments
                    ?.getString("subjectId")
                ?: return@composable

            val subjectId =
                toQuestionSubjectId(rawSubjectId)

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
