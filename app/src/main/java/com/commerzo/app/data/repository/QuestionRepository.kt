package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.model.QuestionDifficulty

class QuestionRepository {

    fun getQuestions(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): List<Question> {

        val questions = when (chapterId) {

            "accountancy_class_12_1" ->
                accountancyPartnership(
                    subjectId,
                    chapterId,
                    board,
                    classLevel
                )

            "business_studies_class_12_1" ->
                businessManagement(
                    subjectId,
                    chapterId,
                    board,
                    classLevel
                )

            "economics_class_12_1" ->
                nationalIncome(
                    subjectId,
                    chapterId,
                    board,
                    classLevel
                )

            "mathematics_class_12_3" ->
                matrices(
                    subjectId,
                    chapterId,
                    board,
                    classLevel
                )

            else ->
                emptyList()
        }

        return questions
            .filter {
                it.subjectId == subjectId &&
                    it.chapterId == chapterId &&
                    it.board == board &&
                    it.classLevel == classLevel
            }
            .distinctBy { it.id }
    }

    private fun accountancyPartnership(
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel
    ): List<Question> {

        return listOf(
            Question(
                id = "acc_partnership_001",
                question = "A partnership is formed by an agreement between two or more persons to carry on a business and share its profits. Which account records the distribution of profit among partners?",
                options = listOf(
                    "Profit and Loss Appropriation Account",
                    "Trading Account",
                    "Cash Account",
                    "Realisation Account"
                ),
                correctAnswer = 0,
                explanation = "The Profit and Loss Appropriation Account records the distribution and appropriation of profit among partners.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("partnership", "appropriation")
            ),
            Question(
                id = "acc_partnership_002",
                question = "Which account is prepared to record interest on capital allowed to partners?",
                options = listOf(
                    "Profit and Loss Appropriation Account",
                    "Trading Account",
                    "Balance Sheet",
                    "Cash Flow Statement"
                ),
                correctAnswer = 0,
                explanation = "Interest on capital is an appropriation of profit and is therefore recorded through the Profit and Loss Appropriation Account.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("interest", "capital", "appropriation")
            ),
            Question(
                id = "acc_partnership_003",
                question = "In the absence of an agreement, partners generally share profits and losses in which ratio?",
                options = listOf(
                    "Equal ratio",
                    "Capital ratio",
                    "Sales ratio",
                    "Asset ratio"
                ),
                correctAnswer = 0,
                explanation = "Under the Partnership Act, in the absence of an agreement, profits and losses are shared equally among partners.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("profit sharing", "partnership act")
            ),
            Question(
                id = "acc_partnership_004",
                question = "Interest on drawings is treated as what for the firm?",
                options = listOf(
                    "Income",
                    "Asset",
                    "Capital",
                    "Liability"
                ),
                correctAnswer = 0,
                explanation = "Interest on drawings is charged from partners and becomes an income for the firm.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("drawings", "interest")
            ),
            Question(
                id = "acc_partnership_005",
                question = "Which account is credited when interest on capital is allowed to a partner?",
                options = listOf(
                    "Partner's Capital or Current Account",
                    "Cash Account",
                    "Trading Account",
                    "Purchases Account"
                ),
                correctAnswer = 0,
                explanation = "Interest on capital is credited to the concerned partner's Capital Account or Current Account, depending on the accounting system followed.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("interest", "capital account")
            )
        )
    }

    private fun businessManagement(
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel
    ): List<Question> {

        return listOf(
            Question(
                id = "bst_management_001",
                question = "Which function of management involves setting objectives and deciding in advance what is to be done?",
                options = listOf(
                    "Planning",
                    "Staffing",
                    "Directing",
                    "Controlling"
                ),
                correctAnswer = 0,
                explanation = "Planning involves setting objectives and deciding in advance the course of action to achieve them.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("management", "planning")
            ),
            Question(
                id = "bst_management_002",
                question = "Which level of management is mainly responsible for implementing plans and supervising employees?",
                options = listOf(
                    "Middle-level management",
                    "Top-level management",
                    "Board of directors only",
                    "External management"
                ),
                correctAnswer = 0,
                explanation = "Middle-level managers implement plans and coordinate and supervise the activities of lower-level managers and employees.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("management levels", "middle management")
            )
        )
    }

    private fun nationalIncome(
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel
    ): List<Question> {

        return listOf(
            Question(
                id = "eco_national_income_001",
                question = "National income is generally defined as the net factor income earned by the normal residents of a country during a period of:",
                options = listOf(
                    "One accounting year",
                    "One month",
                    "One week",
                    "One day"
                ),
                correctAnswer = 0,
                explanation = "National income is measured over an accounting period, generally one financial or accounting year.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("national income", "basic concepts")
            ),
            Question(
                id = "eco_national_income_002",
                question = "GDP measures the value of final goods and services produced within the domestic territory of a country during a given period.",
                options = listOf(
                    "True",
                    "False",
                    "Only for exports",
                    "Only for agriculture"
                ),
                correctAnswer = 0,
                explanation = "GDP measures the market value of final goods and services produced within the domestic territory during a specified period.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("GDP", "national income")
            )
        )
    }

    private fun matrices(
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel
    ): List<Question> {

        return listOf(
            Question(
                id = "math_matrices_001",
                question = "A matrix having the same number of rows and columns is called:",
                options = listOf(
                    "Square matrix",
                    "Row matrix",
                    "Column matrix",
                    "Rectangular matrix"
                ),
                correctAnswer = 0,
                explanation = "A matrix with an equal number of rows and columns is called a square matrix.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("matrices", "square matrix")
            ),
            Question(
                id = "math_matrices_002",
                question = "What is the order of a matrix having 3 rows and 4 columns?",
                options = listOf(
                    "3 × 4",
                    "4 × 3",
                    "3 + 4",
                    "12 × 1"
                ),
                correctAnswer = 0,
                explanation = "The order of a matrix is written as number of rows × number of columns. Therefore, its order is 3 × 4.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("matrices", "order")
            )
        )
    }
}
