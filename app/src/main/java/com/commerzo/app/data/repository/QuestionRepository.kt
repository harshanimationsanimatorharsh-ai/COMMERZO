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

        return when (chapterId) {

            "accountancy_class_12_1" -> accountancyPartnership(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )

            "business_studies_class_12_1" -> businessManagement(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )

            "economics_class_12_1" -> nationalIncome(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )

            "mathematics_class_12_3" -> matrices(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )

            else -> demoQuestions(
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel
            )
        }
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
                question = "Partnership deed is a document containing the terms and conditions of partnership.",
                options = listOf(
                    "True",
                    "False",
                    "Only for companies",
                    "Only for sole traders"
                ),
                correctAnswer = 0,
                explanation = "A partnership deed records the terms and conditions agreed upon by partners.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("partnership", "basics")
            ),
            Question(
                id = "acc_partnership_002",
                question = "In the absence of an agreement, partners generally share profits and losses in which ratio?",
                options = listOf(
                    "Capital ratio",
                    "Equal ratio",
                    "Sales ratio",
                    "Current account ratio"
                ),
                correctAnswer = 1,
                explanation = "In the absence of an agreement, profits and losses are shared equally among partners.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("profit", "loss", "partnership")
            ),
            Question(
                id = "acc_partnership_003",
                question = "Which account is prepared to record changes in the values of assets and liabilities during reconstitution?",
                options = listOf(
                    "Capital Account",
                    "Cash Account",
                    "Revaluation Account",
                    "Trading Account"
                ),
                correctAnswer = 2,
                explanation = "The Revaluation Account records increases or decreases in the values of assets and liabilities.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("revaluation", "reconstitution")
            ),
            Question(
                id = "acc_partnership_004",
                question = "Goodwill represents the reputation and other intangible advantages of a business.",
                options = listOf(
                    "True",
                    "False",
                    "Only a current asset",
                    "Only a liability"
                ),
                correctAnswer = 0,
                explanation = "Goodwill is an intangible asset representing the reputation and earning advantage of a business.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("goodwill", "intangible-asset")
            ),
            Question(
                id = "acc_partnership_005",
                question = "When a new partner is admitted, the new partner usually brings goodwill for his or her share.",
                options = listOf(
                    "Never",
                    "Only when business closes",
                    "Usually",
                    "Only in a company"
                ),
                correctAnswer = 2,
                explanation = "On admission, a new partner may bring goodwill as compensation to existing partners for the share acquired.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("admission", "goodwill")
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
                question = "Management is the process of getting things done effectively and efficiently.",
                options = listOf(
                    "True",
                    "False",
                    "Only a production activity",
                    "Only a financial activity"
                ),
                correctAnswer = 0,
                explanation = "Management involves achieving organisational goals effectively and efficiently.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("management", "basics")
            ),
            Question(
                id = "bst_management_002",
                question = "Which function of management involves setting objectives and deciding in advance what should be done?",
                options = listOf(
                    "Planning",
                    "Staffing",
                    "Directing",
                    "Controlling"
                ),
                correctAnswer = 0,
                explanation = "Planning involves setting objectives and deciding in advance the course of action.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("planning", "functions")
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
                question = "GDP measures the value of final goods and services produced within a country's domestic territory.",
                options = listOf(
                    "True",
                    "False",
                    "Only exports",
                    "Only imports"
                ),
                correctAnswer = 0,
                explanation = "GDP measures the market value of final goods and services produced within domestic territory during a period.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("GDP", "national-income")
            ),
            Question(
                id = "eco_national_income_002",
                question = "Which of the following is deducted from GDP at market price to obtain GDP at factor cost?",
                options = listOf(
                    "Subsidies",
                    "Net factor income",
                    "Net indirect taxes",
                    "Depreciation"
                ),
                correctAnswer = 2,
                explanation = "GDP at factor cost can be obtained by subtracting net indirect taxes from GDP at market price.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("GDP", "factor-cost", "taxes")
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
                question = "A matrix having the same number of rows and columns is called a square matrix.",
                options = listOf(
                    "True",
                    "False",
                    "Row matrix",
                    "Column matrix"
                ),
                correctAnswer = 0,
                explanation = "A square matrix has an equal number of rows and columns.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("matrices", "square-matrix")
            ),
            Question(
                id = "math_matrices_002",
                question = "If a matrix has 3 rows and 2 columns, what is its order?",
                options = listOf(
                    "2 × 3",
                    "3 × 2",
                    "3 × 3",
                    "2 × 2"
                ),
                correctAnswer = 1,
                explanation = "The order of a matrix is written as rows × columns. Therefore, the order is 3 × 2.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("matrices", "order")
            )
        )
    }

    private fun demoQuestions(
        subjectId: String,
        chapterId: String,
        board: Board,
        classLevel: ClassLevel
    ): List<Question> {
        return listOf(
            Question(
                id = "${chapterId}_demo_001",
                question = "This chapter's question bank is ready to be expanded with verified questions.",
                options = listOf(
                    "Question bank",
                    "Attendance",
                    "Profile",
                    "Settings"
                ),
                correctAnswer = 0,
                explanation = "COMMERZO uses a chapter-wise question architecture so verified questions can be added chapter by chapter.",
                subjectId = subjectId,
                chapterId = chapterId,
                board = board,
                classLevel = classLevel,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("demo", "chapter")
            )
        )
    }
}
