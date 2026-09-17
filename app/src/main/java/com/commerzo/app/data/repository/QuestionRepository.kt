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

        return questionBank()
            .filter {
                it.subjectId == subjectId &&
                    it.chapterId == chapterId &&
                    it.board == board &&
                    it.classLevel == classLevel
            }
    }

    /*
     * Backward-compatible overload for older callers.
     */
    fun getQuestions(
        subjectId: String,
        chapterId: String
    ): List<Question> {
        return getQuestions(
            subjectId = subjectId,
            chapterId = chapterId,
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12
        )
    }

    private fun questionBank(): List<Question> {

        return listOf(

            // ---------------------------------------------------------
            // ACCOUNTANCY — CLASS 12 — MP BOARD
            // Chapter 1: Accounting for Partnership: Basic Concepts
            // ---------------------------------------------------------

            Question(
                id = "acc_001",
                question = "In a partnership firm, the ratio in which partners agree to share profits and losses is called:",
                options = listOf(
                    "Capital ratio",
                    "Profit-sharing ratio",
                    "Current ratio",
                    "Debt-equity ratio"
                ),
                correctAnswer = 1,
                explanation = "The profit-sharing ratio is the ratio in which partners agree to share the profits and losses of the firm.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("partnership", "profit-sharing-ratio")
            ),

            Question(
                id = "acc_002",
                question = "If there is no partnership agreement, profits and losses are generally shared by partners in:",
                options = listOf(
                    "Their capital ratio",
                    "Their salary ratio",
                    "Equal ratio",
                    "Their drawings ratio"
                ),
                correctAnswer = 2,
                explanation = "In the absence of an agreement, partners generally share profits and losses equally.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("partnership", "partnership-act")
            ),

            Question(
                id = "acc_003",
                question = "Interest on partner's capital is allowed only when it is provided by:",
                options = listOf(
                    "The Partnership Deed",
                    "The Cash Book",
                    "The Balance Sheet",
                    "The Trial Balance"
                ),
                correctAnswer = 0,
                explanation = "Interest on partners' capital is allowed when the partnership agreement or deed provides for it.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("interest-on-capital", "partnership-deed")
            ),

            Question(
                id = "acc_004",
                question = "A partner's salary is treated as an appropriation of:",
                options = listOf(
                    "Gross profit",
                    "Net profit",
                    "Capital",
                    "Assets"
                ),
                correctAnswer = 1,
                explanation = "Partner's salary is an appropriation of profit and is recorded through the Profit and Loss Appropriation Account.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("partner-salary", "appropriation")
            ),

            Question(
                id = "acc_005",
                question = "The account prepared to show the distribution of profit among partners is:",
                options = listOf(
                    "Trading Account",
                    "Profit and Loss Account",
                    "Profit and Loss Appropriation Account",
                    "Revaluation Account"
                ),
                correctAnswer = 2,
                explanation = "The Profit and Loss Appropriation Account shows how the firm's profit is appropriated among partners.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("appropriation-account", "partnership")
            ),

            // ---------------------------------------------------------
            // BUSINESS STUDIES — CLASS 12 — MP BOARD
            // Chapter 1: Nature and Significance of Management
            // ---------------------------------------------------------

            Question(
                id = "bst_001",
                question = "Which of the following is a characteristic of management?",
                options = listOf(
                    "Management is a one-time activity",
                    "Management is a continuous process",
                    "Management is performed only by owners",
                    "Management has no specific objective"
                ),
                correctAnswer = 1,
                explanation = "Management is a continuous process because planning, organising, staffing, directing and controlling continue throughout the life of an organisation.",
                subjectId = "business_studies",
                chapterId = "business_studies_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("management", "characteristics")
            ),

            Question(
                id = "bst_002",
                question = "Coordination is often described as the:",
                options = listOf(
                    "First function of management",
                    "Essence of management",
                    "Final objective of business",
                    "Source of finance"
                ),
                correctAnswer = 1,
                explanation = "Coordination integrates the efforts of different individuals and departments towards common organisational goals and is therefore called the essence of management.",
                subjectId = "business_studies",
                chapterId = "business_studies_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("coordination", "management")
            ),

            // ---------------------------------------------------------
            // ECONOMICS — CLASS 12 — MP BOARD
            // Macro Chapter 2: National Income Accounting
            // ---------------------------------------------------------

            Question(
                id = "eco_001",
                question = "GDP measures the value of final goods and services produced within the domestic territory of a country during a:",
                options = listOf(
                    "Financial transaction",
                    "Specified period",
                    "Single business day",
                    "Only export cycle"
                ),
                correctAnswer = 1,
                explanation = "Gross Domestic Product measures the market value of final goods and services produced within the domestic territory during a specified period, usually one year.",
                subjectId = "economics",
                chapterId = "economics_class_12_macro_2",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("GDP", "national-income")
            ),

            Question(
                id = "eco_002",
                question = "Which of the following is included while calculating national income?",
                options = listOf(
                    "Transfer payments",
                    "Sale of second-hand goods",
                    "Factor income from abroad",
                    "Purchase of shares"
                ),
                correctAnswer = 2,
                explanation = "Factor income from abroad is considered while moving from domestic product measures to national product measures.",
                subjectId = "economics",
                chapterId = "economics_class_12_macro_2",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("national-income", "factor-income")
            ),

            // ---------------------------------------------------------
            // MATHEMATICS — CLASS 12 — MP BOARD
            // Chapter 3: Matrices
            // ---------------------------------------------------------

            Question(
                id = "math_001",
                question = "If a matrix has 3 rows and 2 columns, its order is:",
                options = listOf(
                    "2 × 3",
                    "3 × 2",
                    "3 × 3",
                    "2 × 2"
                ),
                correctAnswer = 1,
                explanation = "The order of a matrix is written as number of rows × number of columns. Therefore, the order is 3 × 2.",
                subjectId = "mathematics",
                chapterId = "mathematics_class_12_3",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("matrices", "order-of-matrix")
            ),

            Question(
                id = "math_002",
                question = "A matrix having the same number of rows and columns is called a:",
                options = listOf(
                    "Row matrix",
                    "Column matrix",
                    "Square matrix",
                    "Null matrix"
                ),
                correctAnswer = 2,
                explanation = "A matrix with an equal number of rows and columns is called a square matrix.",
                subjectId = "mathematics",
                chapterId = "mathematics_class_12_3",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("matrices", "square-matrix")
            )
        )
    }
}
