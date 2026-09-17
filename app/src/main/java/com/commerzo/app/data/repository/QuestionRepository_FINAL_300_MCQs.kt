package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.model.QuestionDifficulty

class QuestionRepository {

    fun getQuestions(subjectId: String, chapterId: String, board: Board = Board.MP_BOARD, classLevel: ClassLevel = ClassLevel.CLASS_12): List<Question> =
        questionBank().filter { it.subjectId == subjectId && it.chapterId == chapterId && it.board == board && it.classLevel == classLevel }

    fun getQuestions(subjectId: String, chapterId: String): List<Question> =
        getQuestions(subjectId, chapterId, Board.MP_BOARD, ClassLevel.CLASS_12)

    private fun questionBank(): List<Question> = listOf(
        Question(
            id = "accountancy_class_12__001",
            question = "In the absence of a partnership deed, profits and losses are shared:",
            options = listOf(
                "Equally",
                "In capital ratio",
                "In drawings ratio",
                "At directors discretion"
            ),
            correctAnswer = 0,
            explanation = "In the absence of an agreement, partners share profits and losses equally.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__002",
            question = "Interest on drawings is charged when:",
            options = listOf(
                "The agreement provides for it",
                "A partner demands it",
                "Sales fall",
                "Capital increases"
            ),
            correctAnswer = 0,
            explanation = "Interest on drawings is charged according to the partnership agreement.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__003",
            question = "Goodwill is classified as:",
            options = listOf(
                "Intangible asset",
                "Current liability",
                "Fictitious asset",
                "Revenue receipt"
            ),
            correctAnswer = 0,
            explanation = "Goodwill is an intangible asset representing business reputation.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__004",
            question = "A new partner is admitted with the consent of:",
            options = listOf(
                "All existing partners",
                "Any one partner",
                "Creditors only",
                "Employees only"
            ),
            correctAnswer = 0,
            explanation = "Admission of a partner requires consent of all existing partners.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__005",
            question = "The ratio in which old partners sacrifice their share is called:",
            options = listOf(
                "Sacrificing ratio",
                "Gaining ratio",
                "Current ratio",
                "Debt ratio"
            ),
            correctAnswer = 0,
            explanation = "Sacrificing ratio measures the share surrendered by old partners.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__006",
            question = "The ratio in which continuing partners acquire a retiring partner’s share is:",
            options = listOf(
                "Gaining ratio",
                "Sacrificing ratio",
                "Capital ratio",
                "Current ratio"
            ),
            correctAnswer = 0,
            explanation = "Gaining ratio shows the share acquired by continuing partners.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__007",
            question = "The account prepared to record realization of assets and liabilities is:",
            options = listOf(
                "Realisation Account",
                "Capital Account",
                "Trading Account",
                "Cash Account"
            ),
            correctAnswer = 0,
            explanation = "Realisation Account records realization of assets and settlement of liabilities.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__008",
            question = "Shares issued above face value are issued at:",
            options = listOf(
                "Premium",
                "Discount",
                "Par",
                "Loss"
            ),
            correctAnswer = 0,
            explanation = "An issue price above face value is a premium.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__009",
            question = "A debenture represents:",
            options = listOf(
                "Debt of a company",
                "Owner’s capital",
                "Inventory",
                "Revenue"
            ),
            correctAnswer = 0,
            explanation = "A debenture is a debt instrument of a company.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__010",
            question = "The Balance Sheet shows financial position:",
            options = listOf(
                "At a particular date",
                "For one transaction only",
                "Only at incorporation",
                "Only after liquidation"
            ),
            correctAnswer = 0,
            explanation = "The Balance Sheet presents financial position at a specific date.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__011",
            question = "Current Ratio is calculated as:",
            options = listOf(
                "Current Assets / Current Liabilities",
                "Current Liabilities / Current Assets",
                "Debt / Equity",
                "Profit / Sales"
            ),
            correctAnswer = 0,
            explanation = "Current Ratio = Current Assets ÷ Current Liabilities.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__012",
            question = "Debt-Equity Ratio mainly measures:",
            options = listOf(
                "Long-term solvency",
                "Short-term liquidity",
                "Inventory movement",
                "Gross margin"
            ),
            correctAnswer = 0,
            explanation = "Debt-Equity Ratio indicates long-term financial risk/solvency.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__013",
            question = "Cash flows are classified into:",
            options = listOf(
                "Operating, investing and financing",
                "Trading, capital and revenue",
                "Current, fixed and liquid",
                "Profit, loss and reserve"
            ),
            correctAnswer = 0,
            explanation = "Cash flows are classified into operating, investing and financing activities.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__014",
            question = "Purchase of machinery for cash is a/an:",
            options = listOf(
                "Investing cash flow",
                "Operating cash flow",
                "Financing cash flow",
                "Non-cash flow"
            ),
            correctAnswer = 0,
            explanation = "Purchase of a long-term asset is an investing activity.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__015",
            question = "In the absence of a partnership deed, profits and losses are shared:",
            options = listOf(
                "Equally",
                "In capital ratio",
                "In drawings ratio",
                "At directors discretion"
            ),
            correctAnswer = 0,
            explanation = "In the absence of an agreement, partners share profits and losses equally.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__016",
            question = "Interest on drawings is charged when:",
            options = listOf(
                "The agreement provides for it",
                "A partner demands it",
                "Sales fall",
                "Capital increases"
            ),
            correctAnswer = 0,
            explanation = "Interest on drawings is charged according to the partnership agreement.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__017",
            question = "Goodwill is classified as:",
            options = listOf(
                "Intangible asset",
                "Current liability",
                "Fictitious asset",
                "Revenue receipt"
            ),
            correctAnswer = 0,
            explanation = "Goodwill is an intangible asset representing business reputation.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__018",
            question = "A new partner is admitted with the consent of:",
            options = listOf(
                "All existing partners",
                "Any one partner",
                "Creditors only",
                "Employees only"
            ),
            correctAnswer = 0,
            explanation = "Admission of a partner requires consent of all existing partners.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__019",
            question = "The ratio in which old partners sacrifice their share is called:",
            options = listOf(
                "Sacrificing ratio",
                "Gaining ratio",
                "Current ratio",
                "Debt ratio"
            ),
            correctAnswer = 0,
            explanation = "Sacrificing ratio measures the share surrendered by old partners.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__020",
            question = "The ratio in which continuing partners acquire a retiring partner’s share is:",
            options = listOf(
                "Gaining ratio",
                "Sacrificing ratio",
                "Capital ratio",
                "Current ratio"
            ),
            correctAnswer = 0,
            explanation = "Gaining ratio shows the share acquired by continuing partners.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__021",
            question = "The account prepared to record realization of assets and liabilities is:",
            options = listOf(
                "Realisation Account",
                "Capital Account",
                "Trading Account",
                "Cash Account"
            ),
            correctAnswer = 0,
            explanation = "Realisation Account records realization of assets and settlement of liabilities.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__022",
            question = "Shares issued above face value are issued at:",
            options = listOf(
                "Premium",
                "Discount",
                "Par",
                "Loss"
            ),
            correctAnswer = 0,
            explanation = "An issue price above face value is a premium.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__023",
            question = "A debenture represents:",
            options = listOf(
                "Debt of a company",
                "Owner’s capital",
                "Inventory",
                "Revenue"
            ),
            correctAnswer = 0,
            explanation = "A debenture is a debt instrument of a company.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__024",
            question = "The Balance Sheet shows financial position:",
            options = listOf(
                "At a particular date",
                "For one transaction only",
                "Only at incorporation",
                "Only after liquidation"
            ),
            correctAnswer = 0,
            explanation = "The Balance Sheet presents financial position at a specific date.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__025",
            question = "Current Ratio is calculated as:",
            options = listOf(
                "Current Assets / Current Liabilities",
                "Current Liabilities / Current Assets",
                "Debt / Equity",
                "Profit / Sales"
            ),
            correctAnswer = 0,
            explanation = "Current Ratio = Current Assets ÷ Current Liabilities.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__026",
            question = "Debt-Equity Ratio mainly measures:",
            options = listOf(
                "Long-term solvency",
                "Short-term liquidity",
                "Inventory movement",
                "Gross margin"
            ),
            correctAnswer = 0,
            explanation = "Debt-Equity Ratio indicates long-term financial risk/solvency.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__027",
            question = "Cash flows are classified into:",
            options = listOf(
                "Operating, investing and financing",
                "Trading, capital and revenue",
                "Current, fixed and liquid",
                "Profit, loss and reserve"
            ),
            correctAnswer = 0,
            explanation = "Cash flows are classified into operating, investing and financing activities.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__028",
            question = "Purchase of machinery for cash is a/an:",
            options = listOf(
                "Investing cash flow",
                "Operating cash flow",
                "Financing cash flow",
                "Non-cash flow"
            ),
            correctAnswer = 0,
            explanation = "Purchase of a long-term asset is an investing activity.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__029",
            question = "In the absence of a partnership deed, profits and losses are shared:",
            options = listOf(
                "Equally",
                "In capital ratio",
                "In drawings ratio",
                "At directors discretion"
            ),
            correctAnswer = 0,
            explanation = "In the absence of an agreement, partners share profits and losses equally.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__030",
            question = "Interest on drawings is charged when:",
            options = listOf(
                "The agreement provides for it",
                "A partner demands it",
                "Sales fall",
                "Capital increases"
            ),
            correctAnswer = 0,
            explanation = "Interest on drawings is charged according to the partnership agreement.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__031",
            question = "Goodwill is classified as:",
            options = listOf(
                "Intangible asset",
                "Current liability",
                "Fictitious asset",
                "Revenue receipt"
            ),
            correctAnswer = 0,
            explanation = "Goodwill is an intangible asset representing business reputation.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__032",
            question = "A new partner is admitted with the consent of:",
            options = listOf(
                "All existing partners",
                "Any one partner",
                "Creditors only",
                "Employees only"
            ),
            correctAnswer = 0,
            explanation = "Admission of a partner requires consent of all existing partners.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__033",
            question = "The ratio in which old partners sacrifice their share is called:",
            options = listOf(
                "Sacrificing ratio",
                "Gaining ratio",
                "Current ratio",
                "Debt ratio"
            ),
            correctAnswer = 0,
            explanation = "Sacrificing ratio measures the share surrendered by old partners.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__034",
            question = "The ratio in which continuing partners acquire a retiring partner’s share is:",
            options = listOf(
                "Gaining ratio",
                "Sacrificing ratio",
                "Capital ratio",
                "Current ratio"
            ),
            correctAnswer = 0,
            explanation = "Gaining ratio shows the share acquired by continuing partners.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__035",
            question = "The account prepared to record realization of assets and liabilities is:",
            options = listOf(
                "Realisation Account",
                "Capital Account",
                "Trading Account",
                "Cash Account"
            ),
            correctAnswer = 0,
            explanation = "Realisation Account records realization of assets and settlement of liabilities.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__036",
            question = "Shares issued above face value are issued at:",
            options = listOf(
                "Premium",
                "Discount",
                "Par",
                "Loss"
            ),
            correctAnswer = 0,
            explanation = "An issue price above face value is a premium.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__037",
            question = "A debenture represents:",
            options = listOf(
                "Debt of a company",
                "Owner’s capital",
                "Inventory",
                "Revenue"
            ),
            correctAnswer = 0,
            explanation = "A debenture is a debt instrument of a company.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__038",
            question = "The Balance Sheet shows financial position:",
            options = listOf(
                "At a particular date",
                "For one transaction only",
                "Only at incorporation",
                "Only after liquidation"
            ),
            correctAnswer = 0,
            explanation = "The Balance Sheet presents financial position at a specific date.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__039",
            question = "Current Ratio is calculated as:",
            options = listOf(
                "Current Assets / Current Liabilities",
                "Current Liabilities / Current Assets",
                "Debt / Equity",
                "Profit / Sales"
            ),
            correctAnswer = 0,
            explanation = "Current Ratio = Current Assets ÷ Current Liabilities.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__040",
            question = "Debt-Equity Ratio mainly measures:",
            options = listOf(
                "Long-term solvency",
                "Short-term liquidity",
                "Inventory movement",
                "Gross margin"
            ),
            correctAnswer = 0,
            explanation = "Debt-Equity Ratio indicates long-term financial risk/solvency.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__041",
            question = "Cash flows are classified into:",
            options = listOf(
                "Operating, investing and financing",
                "Trading, capital and revenue",
                "Current, fixed and liquid",
                "Profit, loss and reserve"
            ),
            correctAnswer = 0,
            explanation = "Cash flows are classified into operating, investing and financing activities.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__042",
            question = "Purchase of machinery for cash is a/an:",
            options = listOf(
                "Investing cash flow",
                "Operating cash flow",
                "Financing cash flow",
                "Non-cash flow"
            ),
            correctAnswer = 0,
            explanation = "Purchase of a long-term asset is an investing activity.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__043",
            question = "In the absence of a partnership deed, profits and losses are shared:",
            options = listOf(
                "Equally",
                "In capital ratio",
                "In drawings ratio",
                "At directors discretion"
            ),
            correctAnswer = 0,
            explanation = "In the absence of an agreement, partners share profits and losses equally.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__044",
            question = "Interest on drawings is charged when:",
            options = listOf(
                "The agreement provides for it",
                "A partner demands it",
                "Sales fall",
                "Capital increases"
            ),
            correctAnswer = 0,
            explanation = "Interest on drawings is charged according to the partnership agreement.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__045",
            question = "Goodwill is classified as:",
            options = listOf(
                "Intangible asset",
                "Current liability",
                "Fictitious asset",
                "Revenue receipt"
            ),
            correctAnswer = 0,
            explanation = "Goodwill is an intangible asset representing business reputation.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__046",
            question = "A new partner is admitted with the consent of:",
            options = listOf(
                "All existing partners",
                "Any one partner",
                "Creditors only",
                "Employees only"
            ),
            correctAnswer = 0,
            explanation = "Admission of a partner requires consent of all existing partners.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__047",
            question = "The ratio in which old partners sacrifice their share is called:",
            options = listOf(
                "Sacrificing ratio",
                "Gaining ratio",
                "Current ratio",
                "Debt ratio"
            ),
            correctAnswer = 0,
            explanation = "Sacrificing ratio measures the share surrendered by old partners.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__048",
            question = "The ratio in which continuing partners acquire a retiring partner’s share is:",
            options = listOf(
                "Gaining ratio",
                "Sacrificing ratio",
                "Capital ratio",
                "Current ratio"
            ),
            correctAnswer = 0,
            explanation = "Gaining ratio shows the share acquired by continuing partners.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__049",
            question = "The account prepared to record realization of assets and liabilities is:",
            options = listOf(
                "Realisation Account",
                "Capital Account",
                "Trading Account",
                "Cash Account"
            ),
            correctAnswer = 0,
            explanation = "Realisation Account records realization of assets and settlement of liabilities.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "accountancy_class_12__050",
            question = "Shares issued above face value are issued at:",
            options = listOf(
                "Premium",
                "Discount",
                "Par",
                "Loss"
            ),
            correctAnswer = 0,
            explanation = "An issue price above face value is a premium.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__001",
            question = "Management is best described as:",
            options = listOf(
                "A process of achieving goals through coordinated efforts",
                "Only supervision",
                "Only planning",
                "Only accounting"
            ),
            correctAnswer = 0,
            explanation = "Management is a continuous process of achieving objectives through people and resources.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__002",
            question = "Coordination is called the essence of management because it:",
            options = listOf(
                "Integrates individual efforts",
                "Eliminates planning",
                "Replaces staffing",
                "Only controls finance"
            ),
            correctAnswer = 0,
            explanation = "Coordination integrates diverse efforts toward common objectives.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__003",
            question = "Unity of command means an employee should receive orders from:",
            options = listOf(
                "One superior",
                "Two superiors",
                "All managers",
                "Customers"
            ),
            correctAnswer = 0,
            explanation = "Unity of command requires one immediate superior.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__004",
            question = "Scientific management is associated with:",
            options = listOf(
                "F.W. Taylor",
                "Henri Fayol",
                "Elton Mayo",
                "Maslow"
            ),
            correctAnswer = 0,
            explanation = "F.W. Taylor developed scientific management.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__005",
            question = "Technological environment includes:",
            options = listOf(
                "Innovations and technological changes",
                "Tax rates only",
                "Population only",
                "Political parties only"
            ),
            correctAnswer = 0,
            explanation = "Technology includes innovations, inventions and technological changes.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__006",
            question = "Planning means:",
            options = listOf(
                "Deciding in advance what to do and how to do it",
                "Checking actual results only",
                "Recruiting employees only",
                "Selling products only"
            ),
            correctAnswer = 0,
            explanation = "Planning is deciding objectives and courses of action in advance.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__007",
            question = "Delegation involves:",
            options = listOf(
                "Assignment of responsibility and authority",
                "Elimination of authority",
                "Only recruitment",
                "Only control"
            ),
            correctAnswer = 0,
            explanation = "Delegation involves assigning responsibility and granting authority with accountability.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__008",
            question = "Recruitment means:",
            options = listOf(
                "Searching for prospective employees",
                "Final selection only",
                "Training only",
                "Promotion only"
            ),
            correctAnswer = 0,
            explanation = "Recruitment is the process of attracting prospective candidates.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__009",
            question = "Motivation means:",
            options = listOf(
                "Stimulating people to act toward goals",
                "Only paying salaries",
                "Only punishing workers",
                "Only recruiting"
            ),
            correctAnswer = 0,
            explanation = "Motivation stimulates employees to contribute toward objectives.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__010",
            question = "Controlling begins with:",
            options = listOf(
                "Setting performance standards",
                "Taking corrective action",
                "Measuring actual performance",
                "Rewarding employees"
            ),
            correctAnswer = 0,
            explanation = "Standards are set before actual performance is measured.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__011",
            question = "Financial management is concerned with:",
            options = listOf(
                "Procurement and effective utilisation of funds",
                "Only sales",
                "Only recruitment",
                "Only advertising"
            ),
            correctAnswer = 0,
            explanation = "Financial management deals with financial decisions and use of funds.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__012",
            question = "The traditional marketing mix consists of:",
            options = listOf(
                "Product, Price, Place and Promotion",
                "People, Process, Profit and Plan",
                "Cost, Cash, Credit and Capital",
                "Product, Profit, Policy and People"
            ),
            correctAnswer = 0,
            explanation = "The traditional marketing mix has the 4 Ps.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__013",
            question = "The right to be informed gives consumers information about:",
            options = listOf(
                "Quality, quantity, price and relevant product details",
                "Only company profit",
                "Only employee salaries",
                "Only taxes"
            ),
            correctAnswer = 0,
            explanation = "Consumers have a right to essential product information.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__014",
            question = "Management is best described as:",
            options = listOf(
                "A process of achieving goals through coordinated efforts",
                "Only supervision",
                "Only planning",
                "Only accounting"
            ),
            correctAnswer = 0,
            explanation = "Management is a continuous process of achieving objectives through people and resources.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__015",
            question = "Coordination is called the essence of management because it:",
            options = listOf(
                "Integrates individual efforts",
                "Eliminates planning",
                "Replaces staffing",
                "Only controls finance"
            ),
            correctAnswer = 0,
            explanation = "Coordination integrates diverse efforts toward common objectives.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__016",
            question = "Unity of command means an employee should receive orders from:",
            options = listOf(
                "One superior",
                "Two superiors",
                "All managers",
                "Customers"
            ),
            correctAnswer = 0,
            explanation = "Unity of command requires one immediate superior.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__017",
            question = "Scientific management is associated with:",
            options = listOf(
                "F.W. Taylor",
                "Henri Fayol",
                "Elton Mayo",
                "Maslow"
            ),
            correctAnswer = 0,
            explanation = "F.W. Taylor developed scientific management.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__018",
            question = "Technological environment includes:",
            options = listOf(
                "Innovations and technological changes",
                "Tax rates only",
                "Population only",
                "Political parties only"
            ),
            correctAnswer = 0,
            explanation = "Technology includes innovations, inventions and technological changes.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__019",
            question = "Planning means:",
            options = listOf(
                "Deciding in advance what to do and how to do it",
                "Checking actual results only",
                "Recruiting employees only",
                "Selling products only"
            ),
            correctAnswer = 0,
            explanation = "Planning is deciding objectives and courses of action in advance.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__020",
            question = "Delegation involves:",
            options = listOf(
                "Assignment of responsibility and authority",
                "Elimination of authority",
                "Only recruitment",
                "Only control"
            ),
            correctAnswer = 0,
            explanation = "Delegation involves assigning responsibility and granting authority with accountability.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__021",
            question = "Recruitment means:",
            options = listOf(
                "Searching for prospective employees",
                "Final selection only",
                "Training only",
                "Promotion only"
            ),
            correctAnswer = 0,
            explanation = "Recruitment is the process of attracting prospective candidates.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__022",
            question = "Motivation means:",
            options = listOf(
                "Stimulating people to act toward goals",
                "Only paying salaries",
                "Only punishing workers",
                "Only recruiting"
            ),
            correctAnswer = 0,
            explanation = "Motivation stimulates employees to contribute toward objectives.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__023",
            question = "Controlling begins with:",
            options = listOf(
                "Setting performance standards",
                "Taking corrective action",
                "Measuring actual performance",
                "Rewarding employees"
            ),
            correctAnswer = 0,
            explanation = "Standards are set before actual performance is measured.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__024",
            question = "Financial management is concerned with:",
            options = listOf(
                "Procurement and effective utilisation of funds",
                "Only sales",
                "Only recruitment",
                "Only advertising"
            ),
            correctAnswer = 0,
            explanation = "Financial management deals with financial decisions and use of funds.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__025",
            question = "The traditional marketing mix consists of:",
            options = listOf(
                "Product, Price, Place and Promotion",
                "People, Process, Profit and Plan",
                "Cost, Cash, Credit and Capital",
                "Product, Profit, Policy and People"
            ),
            correctAnswer = 0,
            explanation = "The traditional marketing mix has the 4 Ps.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__026",
            question = "The right to be informed gives consumers information about:",
            options = listOf(
                "Quality, quantity, price and relevant product details",
                "Only company profit",
                "Only employee salaries",
                "Only taxes"
            ),
            correctAnswer = 0,
            explanation = "Consumers have a right to essential product information.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__027",
            question = "Management is best described as:",
            options = listOf(
                "A process of achieving goals through coordinated efforts",
                "Only supervision",
                "Only planning",
                "Only accounting"
            ),
            correctAnswer = 0,
            explanation = "Management is a continuous process of achieving objectives through people and resources.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__028",
            question = "Coordination is called the essence of management because it:",
            options = listOf(
                "Integrates individual efforts",
                "Eliminates planning",
                "Replaces staffing",
                "Only controls finance"
            ),
            correctAnswer = 0,
            explanation = "Coordination integrates diverse efforts toward common objectives.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__029",
            question = "Unity of command means an employee should receive orders from:",
            options = listOf(
                "One superior",
                "Two superiors",
                "All managers",
                "Customers"
            ),
            correctAnswer = 0,
            explanation = "Unity of command requires one immediate superior.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__030",
            question = "Scientific management is associated with:",
            options = listOf(
                "F.W. Taylor",
                "Henri Fayol",
                "Elton Mayo",
                "Maslow"
            ),
            correctAnswer = 0,
            explanation = "F.W. Taylor developed scientific management.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__031",
            question = "Technological environment includes:",
            options = listOf(
                "Innovations and technological changes",
                "Tax rates only",
                "Population only",
                "Political parties only"
            ),
            correctAnswer = 0,
            explanation = "Technology includes innovations, inventions and technological changes.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__032",
            question = "Planning means:",
            options = listOf(
                "Deciding in advance what to do and how to do it",
                "Checking actual results only",
                "Recruiting employees only",
                "Selling products only"
            ),
            correctAnswer = 0,
            explanation = "Planning is deciding objectives and courses of action in advance.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__033",
            question = "Delegation involves:",
            options = listOf(
                "Assignment of responsibility and authority",
                "Elimination of authority",
                "Only recruitment",
                "Only control"
            ),
            correctAnswer = 0,
            explanation = "Delegation involves assigning responsibility and granting authority with accountability.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__034",
            question = "Recruitment means:",
            options = listOf(
                "Searching for prospective employees",
                "Final selection only",
                "Training only",
                "Promotion only"
            ),
            correctAnswer = 0,
            explanation = "Recruitment is the process of attracting prospective candidates.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__035",
            question = "Motivation means:",
            options = listOf(
                "Stimulating people to act toward goals",
                "Only paying salaries",
                "Only punishing workers",
                "Only recruiting"
            ),
            correctAnswer = 0,
            explanation = "Motivation stimulates employees to contribute toward objectives.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__036",
            question = "Controlling begins with:",
            options = listOf(
                "Setting performance standards",
                "Taking corrective action",
                "Measuring actual performance",
                "Rewarding employees"
            ),
            correctAnswer = 0,
            explanation = "Standards are set before actual performance is measured.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__037",
            question = "Financial management is concerned with:",
            options = listOf(
                "Procurement and effective utilisation of funds",
                "Only sales",
                "Only recruitment",
                "Only advertising"
            ),
            correctAnswer = 0,
            explanation = "Financial management deals with financial decisions and use of funds.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__038",
            question = "The traditional marketing mix consists of:",
            options = listOf(
                "Product, Price, Place and Promotion",
                "People, Process, Profit and Plan",
                "Cost, Cash, Credit and Capital",
                "Product, Profit, Policy and People"
            ),
            correctAnswer = 0,
            explanation = "The traditional marketing mix has the 4 Ps.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__039",
            question = "The right to be informed gives consumers information about:",
            options = listOf(
                "Quality, quantity, price and relevant product details",
                "Only company profit",
                "Only employee salaries",
                "Only taxes"
            ),
            correctAnswer = 0,
            explanation = "Consumers have a right to essential product information.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__040",
            question = "Management is best described as:",
            options = listOf(
                "A process of achieving goals through coordinated efforts",
                "Only supervision",
                "Only planning",
                "Only accounting"
            ),
            correctAnswer = 0,
            explanation = "Management is a continuous process of achieving objectives through people and resources.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__041",
            question = "Coordination is called the essence of management because it:",
            options = listOf(
                "Integrates individual efforts",
                "Eliminates planning",
                "Replaces staffing",
                "Only controls finance"
            ),
            correctAnswer = 0,
            explanation = "Coordination integrates diverse efforts toward common objectives.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__042",
            question = "Unity of command means an employee should receive orders from:",
            options = listOf(
                "One superior",
                "Two superiors",
                "All managers",
                "Customers"
            ),
            correctAnswer = 0,
            explanation = "Unity of command requires one immediate superior.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__043",
            question = "Scientific management is associated with:",
            options = listOf(
                "F.W. Taylor",
                "Henri Fayol",
                "Elton Mayo",
                "Maslow"
            ),
            correctAnswer = 0,
            explanation = "F.W. Taylor developed scientific management.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__044",
            question = "Technological environment includes:",
            options = listOf(
                "Innovations and technological changes",
                "Tax rates only",
                "Population only",
                "Political parties only"
            ),
            correctAnswer = 0,
            explanation = "Technology includes innovations, inventions and technological changes.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__045",
            question = "Planning means:",
            options = listOf(
                "Deciding in advance what to do and how to do it",
                "Checking actual results only",
                "Recruiting employees only",
                "Selling products only"
            ),
            correctAnswer = 0,
            explanation = "Planning is deciding objectives and courses of action in advance.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__046",
            question = "Delegation involves:",
            options = listOf(
                "Assignment of responsibility and authority",
                "Elimination of authority",
                "Only recruitment",
                "Only control"
            ),
            correctAnswer = 0,
            explanation = "Delegation involves assigning responsibility and granting authority with accountability.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__047",
            question = "Recruitment means:",
            options = listOf(
                "Searching for prospective employees",
                "Final selection only",
                "Training only",
                "Promotion only"
            ),
            correctAnswer = 0,
            explanation = "Recruitment is the process of attracting prospective candidates.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__048",
            question = "Motivation means:",
            options = listOf(
                "Stimulating people to act toward goals",
                "Only paying salaries",
                "Only punishing workers",
                "Only recruiting"
            ),
            correctAnswer = 0,
            explanation = "Motivation stimulates employees to contribute toward objectives.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__049",
            question = "Controlling begins with:",
            options = listOf(
                "Setting performance standards",
                "Taking corrective action",
                "Measuring actual performance",
                "Rewarding employees"
            ),
            correctAnswer = 0,
            explanation = "Standards are set before actual performance is measured.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "business_studies_class_12__050",
            question = "Financial management is concerned with:",
            options = listOf(
                "Procurement and effective utilisation of funds",
                "Only sales",
                "Only recruitment",
                "Only advertising"
            ),
            correctAnswer = 0,
            explanation = "Financial management deals with financial decisions and use of funds.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__001",
            question = "The basic economic problem arises because resources are:",
            options = listOf(
                "Scarce relative to wants",
                "Unlimited",
                "Always free",
                "Equal to wants"
            ),
            correctAnswer = 0,
            explanation = "Scarcity relative to unlimited wants creates the economic problem.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__002",
            question = "Marginal utility is:",
            options = listOf(
                "Change in total utility from one more unit",
                "Total income",
                "Change in price only",
                "Total cost"
            ),
            correctAnswer = 0,
            explanation = "Marginal utility is the additional utility from an additional unit.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__003",
            question = "The law of demand generally shows:",
            options = listOf(
                "Inverse relation between price and quantity demanded",
                "Direct relation always",
                "No relation",
                "Fixed demand"
            ),
            correctAnswer = 0,
            explanation = "Other things equal, quantity demanded generally falls when price rises.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__004",
            question = "Fixed cost in the short run is:",
            options = listOf(
                "Independent of output",
                "Always zero",
                "Equal to variable cost",
                "Dependent on every unit produced"
            ),
            correctAnswer = 0,
            explanation = "Fixed cost does not vary with output in the short run.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__005",
            question = "Under perfect competition, an individual firm is a:",
            options = listOf(
                "Price taker",
                "Price maker",
                "Monopolist",
                "Regulator"
            ),
            correctAnswer = 0,
            explanation = "The market determines price; the individual firm accepts it.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__006",
            question = "Market equilibrium occurs when:",
            options = listOf(
                "Quantity demanded equals quantity supplied",
                "Demand is zero",
                "Supply is zero",
                "Price is zero"
            ),
            correctAnswer = 0,
            explanation = "Equilibrium is the point where demand and supply are equal.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__007",
            question = "Macroeconomics studies:",
            options = listOf(
                "Aggregate economic variables",
                "One consumer only",
                "One firm only",
                "One product only"
            ),
            correctAnswer = 0,
            explanation = "Macroeconomics studies economy-wide aggregates.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__008",
            question = "GDP measures final production within:",
            options = listOf(
                "Domestic territory",
                "Only foreign territory",
                "Only households",
                "Only banks"
            ),
            correctAnswer = 0,
            explanation = "GDP measures final goods and services produced within domestic territory.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__009",
            question = "One major function of money is:",
            options = listOf(
                "Medium of exchange",
                "Only taxation",
                "Only production",
                "Only export"
            ),
            correctAnswer = 0,
            explanation = "Money facilitates exchange as a medium of exchange.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__010",
            question = "A central bank is responsible for:",
            options = listOf(
                "Monetary and banking regulation",
                "Producing consumer goods",
                "Running every firm",
                "Collecting all retail sales"
            ),
            correctAnswer = 0,
            explanation = "The central bank performs monetary and banking functions.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__011",
            question = "Aggregate demand refers to:",
            options = listOf(
                "Total demand for goods and services in an economy",
                "Only exports",
                "Only money supply",
                "Only government purchases"
            ),
            correctAnswer = 0,
            explanation = "Aggregate demand is economy-wide demand for goods and services.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__012",
            question = "Fiscal policy mainly uses:",
            options = listOf(
                "Government taxation and expenditure",
                "Only bank deposits",
                "Only exports",
                "Only wages"
            ),
            correctAnswer = 0,
            explanation = "Fiscal policy uses government revenue and expenditure decisions.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__013",
            question = "Balance of Payments records:",
            options = listOf(
                "Economic transactions with the rest of the world",
                "Only domestic sales",
                "Only government budgets",
                "Only bank deposits"
            ),
            correctAnswer = 0,
            explanation = "BOP records international economic transactions.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__014",
            question = "Liberalisation means:",
            options = listOf(
                "Reducing unnecessary government controls",
                "Increasing all controls",
                "Banning private firms",
                "Ending international trade"
            ),
            correctAnswer = 0,
            explanation = "Liberalisation reduces restrictions on economic activity.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__015",
            question = "Human capital formation includes investment in:",
            options = listOf(
                "Education, health and skills",
                "Only land",
                "Only machines",
                "Only buildings"
            ),
            correctAnswer = 0,
            explanation = "Education, health and skills build human capital.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__016",
            question = "Rural development aims to improve:",
            options = listOf(
                "Economic and social conditions in rural areas",
                "Only city transport",
                "Only stock markets",
                "Only imports"
            ),
            correctAnswer = 0,
            explanation = "Rural development addresses livelihoods, infrastructure and social conditions.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__017",
            question = "Sustainable development means:",
            options = listOf(
                "Meeting present needs without harming future capacity",
                "Using all resources immediately",
                "Ignoring environmental costs",
                "Stopping all development"
            ),
            correctAnswer = 0,
            explanation = "Sustainable development balances present needs and future generations.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__018",
            question = "The basic economic problem arises because resources are:",
            options = listOf(
                "Scarce relative to wants",
                "Unlimited",
                "Always free",
                "Equal to wants"
            ),
            correctAnswer = 0,
            explanation = "Scarcity relative to unlimited wants creates the economic problem.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__019",
            question = "Marginal utility is:",
            options = listOf(
                "Change in total utility from one more unit",
                "Total income",
                "Change in price only",
                "Total cost"
            ),
            correctAnswer = 0,
            explanation = "Marginal utility is the additional utility from an additional unit.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__020",
            question = "The law of demand generally shows:",
            options = listOf(
                "Inverse relation between price and quantity demanded",
                "Direct relation always",
                "No relation",
                "Fixed demand"
            ),
            correctAnswer = 0,
            explanation = "Other things equal, quantity demanded generally falls when price rises.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__021",
            question = "Fixed cost in the short run is:",
            options = listOf(
                "Independent of output",
                "Always zero",
                "Equal to variable cost",
                "Dependent on every unit produced"
            ),
            correctAnswer = 0,
            explanation = "Fixed cost does not vary with output in the short run.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__022",
            question = "Under perfect competition, an individual firm is a:",
            options = listOf(
                "Price taker",
                "Price maker",
                "Monopolist",
                "Regulator"
            ),
            correctAnswer = 0,
            explanation = "The market determines price; the individual firm accepts it.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__023",
            question = "Market equilibrium occurs when:",
            options = listOf(
                "Quantity demanded equals quantity supplied",
                "Demand is zero",
                "Supply is zero",
                "Price is zero"
            ),
            correctAnswer = 0,
            explanation = "Equilibrium is the point where demand and supply are equal.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__024",
            question = "Macroeconomics studies:",
            options = listOf(
                "Aggregate economic variables",
                "One consumer only",
                "One firm only",
                "One product only"
            ),
            correctAnswer = 0,
            explanation = "Macroeconomics studies economy-wide aggregates.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__025",
            question = "GDP measures final production within:",
            options = listOf(
                "Domestic territory",
                "Only foreign territory",
                "Only households",
                "Only banks"
            ),
            correctAnswer = 0,
            explanation = "GDP measures final goods and services produced within domestic territory.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__026",
            question = "One major function of money is:",
            options = listOf(
                "Medium of exchange",
                "Only taxation",
                "Only production",
                "Only export"
            ),
            correctAnswer = 0,
            explanation = "Money facilitates exchange as a medium of exchange.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__027",
            question = "A central bank is responsible for:",
            options = listOf(
                "Monetary and banking regulation",
                "Producing consumer goods",
                "Running every firm",
                "Collecting all retail sales"
            ),
            correctAnswer = 0,
            explanation = "The central bank performs monetary and banking functions.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__028",
            question = "Aggregate demand refers to:",
            options = listOf(
                "Total demand for goods and services in an economy",
                "Only exports",
                "Only money supply",
                "Only government purchases"
            ),
            correctAnswer = 0,
            explanation = "Aggregate demand is economy-wide demand for goods and services.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__029",
            question = "Fiscal policy mainly uses:",
            options = listOf(
                "Government taxation and expenditure",
                "Only bank deposits",
                "Only exports",
                "Only wages"
            ),
            correctAnswer = 0,
            explanation = "Fiscal policy uses government revenue and expenditure decisions.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__030",
            question = "Balance of Payments records:",
            options = listOf(
                "Economic transactions with the rest of the world",
                "Only domestic sales",
                "Only government budgets",
                "Only bank deposits"
            ),
            correctAnswer = 0,
            explanation = "BOP records international economic transactions.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__031",
            question = "Liberalisation means:",
            options = listOf(
                "Reducing unnecessary government controls",
                "Increasing all controls",
                "Banning private firms",
                "Ending international trade"
            ),
            correctAnswer = 0,
            explanation = "Liberalisation reduces restrictions on economic activity.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__032",
            question = "Human capital formation includes investment in:",
            options = listOf(
                "Education, health and skills",
                "Only land",
                "Only machines",
                "Only buildings"
            ),
            correctAnswer = 0,
            explanation = "Education, health and skills build human capital.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__033",
            question = "Rural development aims to improve:",
            options = listOf(
                "Economic and social conditions in rural areas",
                "Only city transport",
                "Only stock markets",
                "Only imports"
            ),
            correctAnswer = 0,
            explanation = "Rural development addresses livelihoods, infrastructure and social conditions.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__034",
            question = "Sustainable development means:",
            options = listOf(
                "Meeting present needs without harming future capacity",
                "Using all resources immediately",
                "Ignoring environmental costs",
                "Stopping all development"
            ),
            correctAnswer = 0,
            explanation = "Sustainable development balances present needs and future generations.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__035",
            question = "The basic economic problem arises because resources are:",
            options = listOf(
                "Scarce relative to wants",
                "Unlimited",
                "Always free",
                "Equal to wants"
            ),
            correctAnswer = 0,
            explanation = "Scarcity relative to unlimited wants creates the economic problem.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__036",
            question = "Marginal utility is:",
            options = listOf(
                "Change in total utility from one more unit",
                "Total income",
                "Change in price only",
                "Total cost"
            ),
            correctAnswer = 0,
            explanation = "Marginal utility is the additional utility from an additional unit.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__037",
            question = "The law of demand generally shows:",
            options = listOf(
                "Inverse relation between price and quantity demanded",
                "Direct relation always",
                "No relation",
                "Fixed demand"
            ),
            correctAnswer = 0,
            explanation = "Other things equal, quantity demanded generally falls when price rises.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__038",
            question = "Fixed cost in the short run is:",
            options = listOf(
                "Independent of output",
                "Always zero",
                "Equal to variable cost",
                "Dependent on every unit produced"
            ),
            correctAnswer = 0,
            explanation = "Fixed cost does not vary with output in the short run.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__039",
            question = "Under perfect competition, an individual firm is a:",
            options = listOf(
                "Price taker",
                "Price maker",
                "Monopolist",
                "Regulator"
            ),
            correctAnswer = 0,
            explanation = "The market determines price; the individual firm accepts it.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__040",
            question = "Market equilibrium occurs when:",
            options = listOf(
                "Quantity demanded equals quantity supplied",
                "Demand is zero",
                "Supply is zero",
                "Price is zero"
            ),
            correctAnswer = 0,
            explanation = "Equilibrium is the point where demand and supply are equal.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__041",
            question = "Macroeconomics studies:",
            options = listOf(
                "Aggregate economic variables",
                "One consumer only",
                "One firm only",
                "One product only"
            ),
            correctAnswer = 0,
            explanation = "Macroeconomics studies economy-wide aggregates.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__042",
            question = "GDP measures final production within:",
            options = listOf(
                "Domestic territory",
                "Only foreign territory",
                "Only households",
                "Only banks"
            ),
            correctAnswer = 0,
            explanation = "GDP measures final goods and services produced within domestic territory.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__043",
            question = "One major function of money is:",
            options = listOf(
                "Medium of exchange",
                "Only taxation",
                "Only production",
                "Only export"
            ),
            correctAnswer = 0,
            explanation = "Money facilitates exchange as a medium of exchange.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__044",
            question = "A central bank is responsible for:",
            options = listOf(
                "Monetary and banking regulation",
                "Producing consumer goods",
                "Running every firm",
                "Collecting all retail sales"
            ),
            correctAnswer = 0,
            explanation = "The central bank performs monetary and banking functions.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__045",
            question = "Aggregate demand refers to:",
            options = listOf(
                "Total demand for goods and services in an economy",
                "Only exports",
                "Only money supply",
                "Only government purchases"
            ),
            correctAnswer = 0,
            explanation = "Aggregate demand is economy-wide demand for goods and services.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__046",
            question = "Fiscal policy mainly uses:",
            options = listOf(
                "Government taxation and expenditure",
                "Only bank deposits",
                "Only exports",
                "Only wages"
            ),
            correctAnswer = 0,
            explanation = "Fiscal policy uses government revenue and expenditure decisions.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__047",
            question = "Balance of Payments records:",
            options = listOf(
                "Economic transactions with the rest of the world",
                "Only domestic sales",
                "Only government budgets",
                "Only bank deposits"
            ),
            correctAnswer = 0,
            explanation = "BOP records international economic transactions.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__048",
            question = "Liberalisation means:",
            options = listOf(
                "Reducing unnecessary government controls",
                "Increasing all controls",
                "Banning private firms",
                "Ending international trade"
            ),
            correctAnswer = 0,
            explanation = "Liberalisation reduces restrictions on economic activity.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__049",
            question = "Human capital formation includes investment in:",
            options = listOf(
                "Education, health and skills",
                "Only land",
                "Only machines",
                "Only buildings"
            ),
            correctAnswer = 0,
            explanation = "Education, health and skills build human capital.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "economics_class_12__050",
            question = "Rural development aims to improve:",
            options = listOf(
                "Economic and social conditions in rural areas",
                "Only city transport",
                "Only stock markets",
                "Only imports"
            ),
            correctAnswer = 0,
            explanation = "Rural development addresses livelihoods, infrastructure and social conditions.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__001",
            question = "Derivative of x^n is:",
            options = listOf(
                "nx^(n-1)",
                "x^(n+1)",
                "n+x",
                "x/n"
            ),
            correctAnswer = 0,
            explanation = "Power rule gives nx^(n-1).",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__002",
            question = "Derivative of sin x is:",
            options = listOf(
                "cos x",
                "-cos x",
                "sin x",
                "-sin x"
            ),
            correctAnswer = 0,
            explanation = "d(sin x)/dx = cos x.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__003",
            question = "Derivative of cos x is:",
            options = listOf(
                "-sin x",
                "sin x",
                "cos x",
                "-cos x"
            ),
            correctAnswer = 0,
            explanation = "d(cos x)/dx = -sin x.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__004",
            question = "A function is continuous at x=a when:",
            options = listOf(
                "lim x→a f(x)=f(a)",
                "f(a)=0 always",
                "Only left limit exists",
                "Derivative is infinite"
            ),
            correctAnswer = 0,
            explanation = "Continuity requires the limit to equal the function value.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__005",
            question = "A matrix with equal rows and columns is:",
            options = listOf(
                "Square matrix",
                "Row matrix",
                "Column matrix",
                "Rectangular matrix"
            ),
            correctAnswer = 0,
            explanation = "A square matrix has equal numbers of rows and columns.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__006",
            question = "A determinant is defined for:",
            options = listOf(
                "Square matrices",
                "All rectangular matrices",
                "Only row matrices",
                "Only column matrices"
            ),
            correctAnswer = 0,
            explanation = "Determinants are defined for square matrices.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__007",
            question = "A square matrix is singular when:",
            options = listOf(
                "det(A)=0",
                "det(A)=1",
                "det(A)>1",
                "A is identity"
            ),
            correctAnswer = 0,
            explanation = "A zero determinant means the matrix is singular.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__008",
            question = "A function assigns each domain element to:",
            options = listOf(
                "Exactly one codomain element",
                "At least two elements",
                "No element",
                "Every element twice"
            ),
            correctAnswer = 0,
            explanation = "A function has a unique image for each domain element.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__009",
            question = "∫x dx equals:",
            options = listOf(
                "x²/2+C",
                "x+C",
                "2x+C",
                "x³+C"
            ),
            correctAnswer = 0,
            explanation = "Using the power rule, ∫x dx = x²/2+C.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__010",
            question = "∫cos x dx equals:",
            options = listOf(
                "sin x+C",
                "-sin x+C",
                "cos x+C",
                "-cos x+C"
            ),
            correctAnswer = 0,
            explanation = "The antiderivative of cos x is sin x+C.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__011",
            question = "The order of a differential equation is the:",
            options = listOf(
                "Highest order derivative present",
                "Lowest derivative",
                "Number of constants",
                "Number of variables"
            ),
            correctAnswer = 0,
            explanation = "Order is the highest derivative order in the equation.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__012",
            question = "A vector has:",
            options = listOf(
                "Magnitude and direction",
                "Only magnitude",
                "Only direction",
                "Neither"
            ),
            correctAnswer = 0,
            explanation = "A vector quantity has both magnitude and direction.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__013",
            question = "Dot product of perpendicular vectors is:",
            options = listOf(
                "0",
                "1",
                "-1",
                "Undefined"
            ),
            correctAnswer = 0,
            explanation = "a·b=|a||b|cos90°=0.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_13",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__014",
            question = "Direction cosines satisfy:",
            options = listOf(
                "l²+m²+n²=1",
                "l+m+n=1",
                "lmn=1",
                "l²+m²+n²=0"
            ),
            correctAnswer = 0,
            explanation = "Direction cosines satisfy the standard identity.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__015",
            question = "Linear programming aims to:",
            options = listOf(
                "Maximise or minimise an objective under constraints",
                "Only differentiate",
                "Only calculate determinants",
                "Only find probability"
            ),
            correctAnswer = 0,
            explanation = "LPP optimises an objective function subject to constraints.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__016",
            question = "Probability of a sure event is:",
            options = listOf(
                "1",
                "0",
                "-1",
                "2"
            ),
            correctAnswer = 0,
            explanation = "A sure event has probability one.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__017",
            question = "Probability of an impossible event is:",
            options = listOf(
                "0",
                "1",
                "-1",
                "2"
            ),
            correctAnswer = 0,
            explanation = "An impossible event has probability zero.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__018",
            question = "For independent A and B:",
            options = listOf(
                "P(A∩B)=P(A)P(B)",
                "P(A∩B)=P(A)+P(B)",
                "P(A)=P(B)",
                "P(A)=0"
            ),
            correctAnswer = 0,
            explanation = "Independence gives the product rule.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__019",
            question = "For a binomial distribution, mean is:",
            options = listOf(
                "np",
                "n+p",
                "n/p",
                "p/n"
            ),
            correctAnswer = 0,
            explanation = "For Bin(n,p), mean=np.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__020",
            question = "Derivative of x^n is:",
            options = listOf(
                "nx^(n-1)",
                "x^(n+1)",
                "n+x",
                "x/n"
            ),
            correctAnswer = 0,
            explanation = "Power rule gives nx^(n-1).",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__021",
            question = "Derivative of sin x is:",
            options = listOf(
                "cos x",
                "-cos x",
                "sin x",
                "-sin x"
            ),
            correctAnswer = 0,
            explanation = "d(sin x)/dx = cos x.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__022",
            question = "Derivative of cos x is:",
            options = listOf(
                "-sin x",
                "sin x",
                "cos x",
                "-cos x"
            ),
            correctAnswer = 0,
            explanation = "d(cos x)/dx = -sin x.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__023",
            question = "A function is continuous at x=a when:",
            options = listOf(
                "lim x→a f(x)=f(a)",
                "f(a)=0 always",
                "Only left limit exists",
                "Derivative is infinite"
            ),
            correctAnswer = 0,
            explanation = "Continuity requires the limit to equal the function value.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__024",
            question = "A matrix with equal rows and columns is:",
            options = listOf(
                "Square matrix",
                "Row matrix",
                "Column matrix",
                "Rectangular matrix"
            ),
            correctAnswer = 0,
            explanation = "A square matrix has equal numbers of rows and columns.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__025",
            question = "A determinant is defined for:",
            options = listOf(
                "Square matrices",
                "All rectangular matrices",
                "Only row matrices",
                "Only column matrices"
            ),
            correctAnswer = 0,
            explanation = "Determinants are defined for square matrices.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__026",
            question = "A square matrix is singular when:",
            options = listOf(
                "det(A)=0",
                "det(A)=1",
                "det(A)>1",
                "A is identity"
            ),
            correctAnswer = 0,
            explanation = "A zero determinant means the matrix is singular.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_13",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__027",
            question = "A function assigns each domain element to:",
            options = listOf(
                "Exactly one codomain element",
                "At least two elements",
                "No element",
                "Every element twice"
            ),
            correctAnswer = 0,
            explanation = "A function has a unique image for each domain element.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__028",
            question = "∫x dx equals:",
            options = listOf(
                "x²/2+C",
                "x+C",
                "2x+C",
                "x³+C"
            ),
            correctAnswer = 0,
            explanation = "Using the power rule, ∫x dx = x²/2+C.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__029",
            question = "∫cos x dx equals:",
            options = listOf(
                "sin x+C",
                "-sin x+C",
                "cos x+C",
                "-cos x+C"
            ),
            correctAnswer = 0,
            explanation = "The antiderivative of cos x is sin x+C.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__030",
            question = "The order of a differential equation is the:",
            options = listOf(
                "Highest order derivative present",
                "Lowest derivative",
                "Number of constants",
                "Number of variables"
            ),
            correctAnswer = 0,
            explanation = "Order is the highest derivative order in the equation.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__031",
            question = "A vector has:",
            options = listOf(
                "Magnitude and direction",
                "Only magnitude",
                "Only direction",
                "Neither"
            ),
            correctAnswer = 0,
            explanation = "A vector quantity has both magnitude and direction.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__032",
            question = "Dot product of perpendicular vectors is:",
            options = listOf(
                "0",
                "1",
                "-1",
                "Undefined"
            ),
            correctAnswer = 0,
            explanation = "a·b=|a||b|cos90°=0.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__033",
            question = "Direction cosines satisfy:",
            options = listOf(
                "l²+m²+n²=1",
                "l+m+n=1",
                "lmn=1",
                "l²+m²+n²=0"
            ),
            correctAnswer = 0,
            explanation = "Direction cosines satisfy the standard identity.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__034",
            question = "Linear programming aims to:",
            options = listOf(
                "Maximise or minimise an objective under constraints",
                "Only differentiate",
                "Only calculate determinants",
                "Only find probability"
            ),
            correctAnswer = 0,
            explanation = "LPP optimises an objective function subject to constraints.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__035",
            question = "Probability of a sure event is:",
            options = listOf(
                "1",
                "0",
                "-1",
                "2"
            ),
            correctAnswer = 0,
            explanation = "A sure event has probability one.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__036",
            question = "Probability of an impossible event is:",
            options = listOf(
                "0",
                "1",
                "-1",
                "2"
            ),
            correctAnswer = 0,
            explanation = "An impossible event has probability zero.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__037",
            question = "For independent A and B:",
            options = listOf(
                "P(A∩B)=P(A)P(B)",
                "P(A∩B)=P(A)+P(B)",
                "P(A)=P(B)",
                "P(A)=0"
            ),
            correctAnswer = 0,
            explanation = "Independence gives the product rule.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__038",
            question = "For a binomial distribution, mean is:",
            options = listOf(
                "np",
                "n+p",
                "n/p",
                "p/n"
            ),
            correctAnswer = 0,
            explanation = "For Bin(n,p), mean=np.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__039",
            question = "Derivative of x^n is:",
            options = listOf(
                "nx^(n-1)",
                "x^(n+1)",
                "n+x",
                "x/n"
            ),
            correctAnswer = 0,
            explanation = "Power rule gives nx^(n-1).",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_13",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__040",
            question = "Derivative of sin x is:",
            options = listOf(
                "cos x",
                "-cos x",
                "sin x",
                "-sin x"
            ),
            correctAnswer = 0,
            explanation = "d(sin x)/dx = cos x.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__041",
            question = "Derivative of cos x is:",
            options = listOf(
                "-sin x",
                "sin x",
                "cos x",
                "-cos x"
            ),
            correctAnswer = 0,
            explanation = "d(cos x)/dx = -sin x.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__042",
            question = "A function is continuous at x=a when:",
            options = listOf(
                "lim x→a f(x)=f(a)",
                "f(a)=0 always",
                "Only left limit exists",
                "Derivative is infinite"
            ),
            correctAnswer = 0,
            explanation = "Continuity requires the limit to equal the function value.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__043",
            question = "A matrix with equal rows and columns is:",
            options = listOf(
                "Square matrix",
                "Row matrix",
                "Column matrix",
                "Rectangular matrix"
            ),
            correctAnswer = 0,
            explanation = "A square matrix has equal numbers of rows and columns.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__044",
            question = "A determinant is defined for:",
            options = listOf(
                "Square matrices",
                "All rectangular matrices",
                "Only row matrices",
                "Only column matrices"
            ),
            correctAnswer = 0,
            explanation = "Determinants are defined for square matrices.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__045",
            question = "A square matrix is singular when:",
            options = listOf(
                "det(A)=0",
                "det(A)=1",
                "det(A)>1",
                "A is identity"
            ),
            correctAnswer = 0,
            explanation = "A zero determinant means the matrix is singular.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__046",
            question = "A function assigns each domain element to:",
            options = listOf(
                "Exactly one codomain element",
                "At least two elements",
                "No element",
                "Every element twice"
            ),
            correctAnswer = 0,
            explanation = "A function has a unique image for each domain element.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__047",
            question = "∫x dx equals:",
            options = listOf(
                "x²/2+C",
                "x+C",
                "2x+C",
                "x³+C"
            ),
            correctAnswer = 0,
            explanation = "Using the power rule, ∫x dx = x²/2+C.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__048",
            question = "∫cos x dx equals:",
            options = listOf(
                "sin x+C",
                "-sin x+C",
                "cos x+C",
                "-cos x+C"
            ),
            correctAnswer = 0,
            explanation = "The antiderivative of cos x is sin x+C.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__049",
            question = "The order of a differential equation is the:",
            options = listOf(
                "Highest order derivative present",
                "Lowest derivative",
                "Number of constants",
                "Number of variables"
            ),
            correctAnswer = 0,
            explanation = "Order is the highest derivative order in the equation.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "mathematics_class_12__050",
            question = "A vector has:",
            options = listOf(
                "Magnitude and direction",
                "Only magnitude",
                "Only direction",
                "Neither"
            ),
            correctAnswer = 0,
            explanation = "A vector quantity has both magnitude and direction.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__001",
            question = "The central idea of a passage is its:",
            options = listOf(
                "Main point",
                "Smallest detail",
                "Last word",
                "Title only"
            ),
            correctAnswer = 0,
            explanation = "The central idea is the main message or point.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__002",
            question = "An inference is:",
            options = listOf(
                "A conclusion drawn from evidence",
                "A direct copy",
                "A heading",
                "A punctuation mark"
            ),
            correctAnswer = 0,
            explanation = "An inference is a reasoned conclusion based on evidence.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__003",
            question = "Formal writing should use:",
            options = listOf(
                "Polite and appropriate language",
                "Slang",
                "Text abbreviations",
                "Very casual language"
            ),
            correctAnswer = 0,
            explanation = "Formal contexts require clear and appropriate language.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__004",
            question = "A notice should be:",
            options = listOf(
                "Concise and informative",
                "A long essay",
                "A diary",
                "A poem"
            ),
            correctAnswer = 0,
            explanation = "A notice communicates essential information briefly.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__005",
            question = "A report mainly presents:",
            options = listOf(
                "Facts and organised information",
                "Only jokes",
                "Only questions",
                "Only fantasy"
            ),
            correctAnswer = 0,
            explanation = "Reports present factual information in an organised form.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__006",
            question = "M. Hamel is the teacher in:",
            options = listOf(
                "The Last Lesson",
                "Lost Spring",
                "Deep Water",
                "Indigo"
            ),
            correctAnswer = 0,
            explanation = "M. Hamel is the French teacher in The Last Lesson.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__007",
            question = "Lost Spring focuses strongly on:",
            options = listOf(
                "Child labour and poverty",
                "Space travel",
                "Sports",
                "Royal life"
            ),
            correctAnswer = 0,
            explanation = "The chapter explores poverty and child labour.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__008",
            question = "Mukesh dreams of becoming a:",
            options = listOf(
                "Motor mechanic",
                "Pilot",
                "Teacher",
                "Doctor"
            ),
            correctAnswer = 0,
            explanation = "Mukesh wants to become a motor mechanic.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__009",
            question = "Deep Water is about overcoming:",
            options = listOf(
                "Fear of water",
                "Fear of heights",
                "Fear of crowds",
                "Fear of travel"
            ),
            correctAnswer = 0,
            explanation = "The narrative centres on overcoming the fear of water.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__010",
            question = "The Rattrap compares the world to:",
            options = listOf(
                "A rattrap",
                "A classroom",
                "A palace",
                "A battlefield"
            ),
            correctAnswer = 0,
            explanation = "The peddler uses the rattrap metaphor for the world.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__011",
            question = "Indigo is associated with:",
            options = listOf(
                "Champaran peasants",
                "A film studio",
                "A sea voyage",
                "A royal court"
            ),
            correctAnswer = 0,
            explanation = "Indigo describes Gandhi’s work with peasants in Champaran.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__012",
            question = "Poets and Pancakes is set at:",
            options = listOf(
                "A film studio",
                "A hospital",
                "A school",
                "A bank"
            ),
            correctAnswer = 0,
            explanation = "The chapter describes life at Gemini Studios.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__013",
            question = "Going Places focuses on:",
            options = listOf(
                "Sophie’s dreams and aspirations",
                "A war",
                "A court case",
                "Agriculture"
            ),
            correctAnswer = 0,
            explanation = "Sophie imagines a glamorous life beyond her ordinary circumstances.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__014",
            question = "The Third Level explores:",
            options = listOf(
                "Escapism and imagined reality",
                "Banking",
                "Sports",
                "Agriculture"
            ),
            correctAnswer = 0,
            explanation = "The story explores escape from modern pressures through an imagined third level.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__015",
            question = "The Tiger King satirises:",
            options = listOf(
                "Royal arrogance and obsession",
                "School discipline",
                "Tourism",
                "Banking"
            ),
            correctAnswer = 0,
            explanation = "The story uses satire to portray the king’s obsession.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__016",
            question = "The Enemy presents a conflict involving:",
            options = listOf(
                "Humanity and wartime duty",
                "Sports teams",
                "Businesses",
                "Schools"
            ),
            correctAnswer = 0,
            explanation = "Dr Sadao faces a moral conflict during wartime.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__017",
            question = "On the Face of It explores:",
            options = listOf(
                "Isolation and acceptance",
                "Business growth",
                "War strategy",
                "Travel"
            ),
            correctAnswer = 0,
            explanation = "The play explores loneliness, acceptance and human connection.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__018",
            question = "A Thing of Beauty suggests beauty provides:",
            options = listOf(
                "Lasting joy and comfort",
                "Only sadness",
                "No value",
                "Only wealth"
            ),
            correctAnswer = 0,
            explanation = "Keats presents beauty as a source of enduring joy.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__019",
            question = "Keeping Quiet encourages:",
            options = listOf(
                "Introspection and peace",
                "Constant competition",
                "War",
                "Consumerism"
            ),
            correctAnswer = 0,
            explanation = "The poem calls for reflection and peace.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__020",
            question = "A metaphor is:",
            options = listOf(
                "A direct comparison without like/as",
                "A question",
                "A list",
                "A punctuation mark"
            ),
            correctAnswer = 0,
            explanation = "A metaphor directly identifies one thing with another.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__021",
            question = "A simile commonly uses:",
            options = listOf(
                "Like or as",
                "Because only",
                "Therefore only",
                "Although only"
            ),
            correctAnswer = 0,
            explanation = "Similes commonly compare using like or as.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__022",
            question = "The central idea of a passage is its:",
            options = listOf(
                "Main point",
                "Smallest detail",
                "Last word",
                "Title only"
            ),
            correctAnswer = 0,
            explanation = "The central idea is the main message or point.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__023",
            question = "An inference is:",
            options = listOf(
                "A conclusion drawn from evidence",
                "A direct copy",
                "A heading",
                "A punctuation mark"
            ),
            correctAnswer = 0,
            explanation = "An inference is a reasoned conclusion based on evidence.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__024",
            question = "Formal writing should use:",
            options = listOf(
                "Polite and appropriate language",
                "Slang",
                "Text abbreviations",
                "Very casual language"
            ),
            correctAnswer = 0,
            explanation = "Formal contexts require clear and appropriate language.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__025",
            question = "A notice should be:",
            options = listOf(
                "Concise and informative",
                "A long essay",
                "A diary",
                "A poem"
            ),
            correctAnswer = 0,
            explanation = "A notice communicates essential information briefly.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__026",
            question = "A report mainly presents:",
            options = listOf(
                "Facts and organised information",
                "Only jokes",
                "Only questions",
                "Only fantasy"
            ),
            correctAnswer = 0,
            explanation = "Reports present factual information in an organised form.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__027",
            question = "M. Hamel is the teacher in:",
            options = listOf(
                "The Last Lesson",
                "Lost Spring",
                "Deep Water",
                "Indigo"
            ),
            correctAnswer = 0,
            explanation = "M. Hamel is the French teacher in The Last Lesson.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__028",
            question = "Lost Spring focuses strongly on:",
            options = listOf(
                "Child labour and poverty",
                "Space travel",
                "Sports",
                "Royal life"
            ),
            correctAnswer = 0,
            explanation = "The chapter explores poverty and child labour.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__029",
            question = "Mukesh dreams of becoming a:",
            options = listOf(
                "Motor mechanic",
                "Pilot",
                "Teacher",
                "Doctor"
            ),
            correctAnswer = 0,
            explanation = "Mukesh wants to become a motor mechanic.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__030",
            question = "Deep Water is about overcoming:",
            options = listOf(
                "Fear of water",
                "Fear of heights",
                "Fear of crowds",
                "Fear of travel"
            ),
            correctAnswer = 0,
            explanation = "The narrative centres on overcoming the fear of water.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__031",
            question = "The Rattrap compares the world to:",
            options = listOf(
                "A rattrap",
                "A classroom",
                "A palace",
                "A battlefield"
            ),
            correctAnswer = 0,
            explanation = "The peddler uses the rattrap metaphor for the world.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__032",
            question = "Indigo is associated with:",
            options = listOf(
                "Champaran peasants",
                "A film studio",
                "A sea voyage",
                "A royal court"
            ),
            correctAnswer = 0,
            explanation = "Indigo describes Gandhi’s work with peasants in Champaran.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__033",
            question = "Poets and Pancakes is set at:",
            options = listOf(
                "A film studio",
                "A hospital",
                "A school",
                "A bank"
            ),
            correctAnswer = 0,
            explanation = "The chapter describes life at Gemini Studios.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__034",
            question = "Going Places focuses on:",
            options = listOf(
                "Sophie’s dreams and aspirations",
                "A war",
                "A court case",
                "Agriculture"
            ),
            correctAnswer = 0,
            explanation = "Sophie imagines a glamorous life beyond her ordinary circumstances.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__035",
            question = "The Third Level explores:",
            options = listOf(
                "Escapism and imagined reality",
                "Banking",
                "Sports",
                "Agriculture"
            ),
            correctAnswer = 0,
            explanation = "The story explores escape from modern pressures through an imagined third level.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__036",
            question = "The Tiger King satirises:",
            options = listOf(
                "Royal arrogance and obsession",
                "School discipline",
                "Tourism",
                "Banking"
            ),
            correctAnswer = 0,
            explanation = "The story uses satire to portray the king’s obsession.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__037",
            question = "The Enemy presents a conflict involving:",
            options = listOf(
                "Humanity and wartime duty",
                "Sports teams",
                "Businesses",
                "Schools"
            ),
            correctAnswer = 0,
            explanation = "Dr Sadao faces a moral conflict during wartime.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__038",
            question = "On the Face of It explores:",
            options = listOf(
                "Isolation and acceptance",
                "Business growth",
                "War strategy",
                "Travel"
            ),
            correctAnswer = 0,
            explanation = "The play explores loneliness, acceptance and human connection.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__039",
            question = "A Thing of Beauty suggests beauty provides:",
            options = listOf(
                "Lasting joy and comfort",
                "Only sadness",
                "No value",
                "Only wealth"
            ),
            correctAnswer = 0,
            explanation = "Keats presents beauty as a source of enduring joy.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__040",
            question = "Keeping Quiet encourages:",
            options = listOf(
                "Introspection and peace",
                "Constant competition",
                "War",
                "Consumerism"
            ),
            correctAnswer = 0,
            explanation = "The poem calls for reflection and peace.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__041",
            question = "A metaphor is:",
            options = listOf(
                "A direct comparison without like/as",
                "A question",
                "A list",
                "A punctuation mark"
            ),
            correctAnswer = 0,
            explanation = "A metaphor directly identifies one thing with another.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__042",
            question = "A simile commonly uses:",
            options = listOf(
                "Like or as",
                "Because only",
                "Therefore only",
                "Although only"
            ),
            correctAnswer = 0,
            explanation = "Similes commonly compare using like or as.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__043",
            question = "The central idea of a passage is its:",
            options = listOf(
                "Main point",
                "Smallest detail",
                "Last word",
                "Title only"
            ),
            correctAnswer = 0,
            explanation = "The central idea is the main message or point.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__044",
            question = "An inference is:",
            options = listOf(
                "A conclusion drawn from evidence",
                "A direct copy",
                "A heading",
                "A punctuation mark"
            ),
            correctAnswer = 0,
            explanation = "An inference is a reasoned conclusion based on evidence.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__045",
            question = "Formal writing should use:",
            options = listOf(
                "Polite and appropriate language",
                "Slang",
                "Text abbreviations",
                "Very casual language"
            ),
            correctAnswer = 0,
            explanation = "Formal contexts require clear and appropriate language.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__046",
            question = "A notice should be:",
            options = listOf(
                "Concise and informative",
                "A long essay",
                "A diary",
                "A poem"
            ),
            correctAnswer = 0,
            explanation = "A notice communicates essential information briefly.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__047",
            question = "A report mainly presents:",
            options = listOf(
                "Facts and organised information",
                "Only jokes",
                "Only questions",
                "Only fantasy"
            ),
            correctAnswer = 0,
            explanation = "Reports present factual information in an organised form.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__048",
            question = "M. Hamel is the teacher in:",
            options = listOf(
                "The Last Lesson",
                "Lost Spring",
                "Deep Water",
                "Indigo"
            ),
            correctAnswer = 0,
            explanation = "M. Hamel is the French teacher in The Last Lesson.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__049",
            question = "Lost Spring focuses strongly on:",
            options = listOf(
                "Child labour and poverty",
                "Space travel",
                "Sports",
                "Royal life"
            ),
            correctAnswer = 0,
            explanation = "The chapter explores poverty and child labour.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "english_class_12__050",
            question = "Mukesh dreams of becoming a:",
            options = listOf(
                "Motor mechanic",
                "Pilot",
                "Teacher",
                "Doctor"
            ),
            correctAnswer = 0,
            explanation = "Mukesh wants to become a motor mechanic.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__001",
            question = "भाषा का मुख्य उद्देश्य क्या है?",
            options = listOf(
                "विचारों का संप्रेषण",
                "केवल मनोरंजन",
                "केवल लेखन",
                "केवल परीक्षा"
            ),
            correctAnswer = 0,
            explanation = "भाषा का प्रमुख कार्य विचारों और भावों का संप्रेषण है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__002",
            question = "साहित्य का प्रमुख आधार क्या है?",
            options = listOf(
                "जीवन और अनुभव",
                "केवल कल्पना",
                "केवल इतिहास",
                "केवल विज्ञान"
            ),
            correctAnswer = 0,
            explanation = "साहित्य जीवन और मानवीय अनुभवों से जुड़ा है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__003",
            question = "भक्तिन की लेखिका कौन हैं?",
            options = listOf(
                "महादेवी वर्मा",
                "मन्नू भंडारी",
                "कृष्णा सोबती",
                "सुभद्रा कुमारी चौहान"
            ),
            correctAnswer = 0,
            explanation = "भक्तिन महादेवी वर्मा की रचना है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__004",
            question = "बाजार दर्शन में मुख्य विचार किससे जुड़ा है?",
            options = listOf(
                "बाजार और उपभोक्ता मनोवृत्ति",
                "युद्ध",
                "कृषि",
                "खेल"
            ),
            correctAnswer = 0,
            explanation = "रचना बाजार और उपभोक्ता व्यवहार पर विचार करती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__005",
            question = "काले मेघा पानी दे का संबंध किससे है?",
            options = listOf(
                "वर्षा और लोकजीवन",
                "युद्ध",
                "व्यापार",
                "शहर"
            ),
            correctAnswer = 0,
            explanation = "रचना वर्षा और लोकजीवन से जुड़े अनुभव प्रस्तुत करती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__006",
            question = "श्रम-विभाजन और जाति-प्रथा के लेखक कौन हैं?",
            options = listOf(
                "डॉ. भीमराव आंबेडकर",
                "रामचंद्र शुक्ल",
                "प्रेमचंद",
                "हरिशंकर परसाई"
            ),
            correctAnswer = 0,
            explanation = "यह रचना डॉ. बी.आर. आंबेडकर के विचारों से संबंधित है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__007",
            question = "सिल्वर वैडिंग में मुख्यतः किसका चित्रण है?",
            options = listOf(
                "पीढ़ियों के बदलते मूल्य",
                "युद्ध",
                "कृषि",
                "यात्रा"
            ),
            correctAnswer = 0,
            explanation = "कहानी में पारिवारिक और पीढ़ीगत मूल्यों के बदलाव को दिखाया गया है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__008",
            question = "जूझ का केंद्रीय भाव किससे जुड़ा है?",
            options = listOf(
                "शिक्षा और संघर्ष",
                "धन",
                "राजनीति",
                "यात्रा"
            ),
            correctAnswer = 0,
            explanation = "जूझ में शिक्षा पाने की इच्छा और संघर्ष प्रमुख है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__009",
            question = "उपमा अलंकार में सामान्यतः किससे तुलना होती है?",
            options = listOf(
                "जैसे/सा/समान आदि",
                "केवल विरोध",
                "केवल प्रश्न",
                "केवल पुनरावृत्ति"
            ),
            correctAnswer = 0,
            explanation = "उपमा में उपमेय और उपमान की तुलना की जाती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__010",
            question = "रूपक अलंकार में:",
            options = listOf(
                "उपमेय पर उपमान का आरोप होता है",
                "केवल प्रश्न होता है",
                "केवल तुक होती है",
                "कोई तुलना नहीं होती"
            ),
            correctAnswer = 0,
            explanation = "रूपक में उपमेय को उपमान के रूप में प्रस्तुत किया जाता है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__011",
            question = "वीर रस का स्थायी भाव है:",
            options = listOf(
                "उत्साह",
                "शोक",
                "हास",
                "भय"
            ),
            correctAnswer = 0,
            explanation = "वीर रस का स्थायी भाव उत्साह है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__012",
            question = "करुण रस का स्थायी भाव है:",
            options = listOf(
                "शोक",
                "उत्साह",
                "हास",
                "क्रोध"
            ),
            correctAnswer = 0,
            explanation = "करुण रस का स्थायी भाव शोक है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__013",
            question = "आत्मपरिचय के कवि कौन हैं?",
            options = listOf(
                "हरिवंश राय बच्चन",
                "निराला",
                "नागार्जुन",
                "मुक्तिबोध"
            ),
            correctAnswer = 0,
            explanation = "आत्मपरिचय हरिवंश राय बच्चन की कविता है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__014",
            question = "उषा कविता में किस समय का चित्रण है?",
            options = listOf(
                "प्रातःकाल",
                "मध्यरात्रि",
                "दोपहर",
                "संध्या"
            ),
            correctAnswer = 0,
            explanation = "उषा में सुबह के प्राकृतिक बिंब हैं।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__015",
            question = "रुबाई किस काव्य रूप से संबंधित है?",
            options = listOf(
                "चार पंक्तियों वाले काव्य रूप से",
                "नाटक से",
                "उपन्यास से",
                "रिपोर्ट से"
            ),
            correctAnswer = 0,
            explanation = "रुबाई चार पंक्तियों का काव्य रूप है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__016",
            question = "औपचारिक पत्र की भाषा कैसी होनी चाहिए?",
            options = listOf(
                "शिष्ट और स्पष्ट",
                "बहुत बोलचाल की",
                "अशिष्ट",
                "अस्पष्ट"
            ),
            correctAnswer = 0,
            explanation = "औपचारिक पत्र में शिष्ट, स्पष्ट और विषयानुकूल भाषा होती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__017",
            question = "विज्ञापन की भाषा सामान्यतः कैसी होती है?",
            options = listOf(
                "संक्षिप्त और आकर्षक",
                "अस्पष्ट",
                "केवल वैज्ञानिक",
                "बहुत लंबी"
            ),
            correctAnswer = 0,
            explanation = "विज्ञापन कम शब्दों में ध्यान आकर्षित करने का प्रयास करता है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__018",
            question = "रिपोर्ट में प्रमुखता होती है:",
            options = listOf(
                "तथ्य और क्रमबद्ध विवरण",
                "केवल कल्पना",
                "केवल संवाद",
                "केवल कविता"
            ),
            correctAnswer = 0,
            explanation = "रिपोर्ट में तथ्यात्मक और क्रमबद्ध प्रस्तुति होती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__019",
            question = "मुहावरा क्या है?",
            options = listOf(
                "विशिष्ट अर्थ देने वाला रूढ़ वाक्यांश",
                "एक अक्षर",
                "केवल संज्ञा",
                "विराम चिन्ह"
            ),
            correctAnswer = 0,
            explanation = "मुहावरा रूढ़ प्रयोग से विशेष अर्थ देता है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__020",
            question = "विशेषण किसकी विशेषता बताता है?",
            options = listOf(
                "संज्ञा या सर्वनाम की",
                "केवल क्रिया की",
                "केवल अव्यय की",
                "केवल विराम चिन्ह की"
            ),
            correctAnswer = 0,
            explanation = "विशेषण संज्ञा या सर्वनाम की विशेषता बताता है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__021",
            question = "भाषा का मुख्य उद्देश्य क्या है?",
            options = listOf(
                "विचारों का संप्रेषण",
                "केवल मनोरंजन",
                "केवल लेखन",
                "केवल परीक्षा"
            ),
            correctAnswer = 0,
            explanation = "भाषा का प्रमुख कार्य विचारों और भावों का संप्रेषण है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__022",
            question = "साहित्य का प्रमुख आधार क्या है?",
            options = listOf(
                "जीवन और अनुभव",
                "केवल कल्पना",
                "केवल इतिहास",
                "केवल विज्ञान"
            ),
            correctAnswer = 0,
            explanation = "साहित्य जीवन और मानवीय अनुभवों से जुड़ा है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__023",
            question = "भक्तिन की लेखिका कौन हैं?",
            options = listOf(
                "महादेवी वर्मा",
                "मन्नू भंडारी",
                "कृष्णा सोबती",
                "सुभद्रा कुमारी चौहान"
            ),
            correctAnswer = 0,
            explanation = "भक्तिन महादेवी वर्मा की रचना है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__024",
            question = "बाजार दर्शन में मुख्य विचार किससे जुड़ा है?",
            options = listOf(
                "बाजार और उपभोक्ता मनोवृत्ति",
                "युद्ध",
                "कृषि",
                "खेल"
            ),
            correctAnswer = 0,
            explanation = "रचना बाजार और उपभोक्ता व्यवहार पर विचार करती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__025",
            question = "काले मेघा पानी दे का संबंध किससे है?",
            options = listOf(
                "वर्षा और लोकजीवन",
                "युद्ध",
                "व्यापार",
                "शहर"
            ),
            correctAnswer = 0,
            explanation = "रचना वर्षा और लोकजीवन से जुड़े अनुभव प्रस्तुत करती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__026",
            question = "श्रम-विभाजन और जाति-प्रथा के लेखक कौन हैं?",
            options = listOf(
                "डॉ. भीमराव आंबेडकर",
                "रामचंद्र शुक्ल",
                "प्रेमचंद",
                "हरिशंकर परसाई"
            ),
            correctAnswer = 0,
            explanation = "यह रचना डॉ. बी.आर. आंबेडकर के विचारों से संबंधित है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__027",
            question = "सिल्वर वैडिंग में मुख्यतः किसका चित्रण है?",
            options = listOf(
                "पीढ़ियों के बदलते मूल्य",
                "युद्ध",
                "कृषि",
                "यात्रा"
            ),
            correctAnswer = 0,
            explanation = "कहानी में पारिवारिक और पीढ़ीगत मूल्यों के बदलाव को दिखाया गया है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__028",
            question = "जूझ का केंद्रीय भाव किससे जुड़ा है?",
            options = listOf(
                "शिक्षा और संघर्ष",
                "धन",
                "राजनीति",
                "यात्रा"
            ),
            correctAnswer = 0,
            explanation = "जूझ में शिक्षा पाने की इच्छा और संघर्ष प्रमुख है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__029",
            question = "उपमा अलंकार में सामान्यतः किससे तुलना होती है?",
            options = listOf(
                "जैसे/सा/समान आदि",
                "केवल विरोध",
                "केवल प्रश्न",
                "केवल पुनरावृत्ति"
            ),
            correctAnswer = 0,
            explanation = "उपमा में उपमेय और उपमान की तुलना की जाती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__030",
            question = "रूपक अलंकार में:",
            options = listOf(
                "उपमेय पर उपमान का आरोप होता है",
                "केवल प्रश्न होता है",
                "केवल तुक होती है",
                "कोई तुलना नहीं होती"
            ),
            correctAnswer = 0,
            explanation = "रूपक में उपमेय को उपमान के रूप में प्रस्तुत किया जाता है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__031",
            question = "वीर रस का स्थायी भाव है:",
            options = listOf(
                "उत्साह",
                "शोक",
                "हास",
                "भय"
            ),
            correctAnswer = 0,
            explanation = "वीर रस का स्थायी भाव उत्साह है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__032",
            question = "करुण रस का स्थायी भाव है:",
            options = listOf(
                "शोक",
                "उत्साह",
                "हास",
                "क्रोध"
            ),
            correctAnswer = 0,
            explanation = "करुण रस का स्थायी भाव शोक है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__033",
            question = "आत्मपरिचय के कवि कौन हैं?",
            options = listOf(
                "हरिवंश राय बच्चन",
                "निराला",
                "नागार्जुन",
                "मुक्तिबोध"
            ),
            correctAnswer = 0,
            explanation = "आत्मपरिचय हरिवंश राय बच्चन की कविता है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__034",
            question = "उषा कविता में किस समय का चित्रण है?",
            options = listOf(
                "प्रातःकाल",
                "मध्यरात्रि",
                "दोपहर",
                "संध्या"
            ),
            correctAnswer = 0,
            explanation = "उषा में सुबह के प्राकृतिक बिंब हैं।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__035",
            question = "रुबाई किस काव्य रूप से संबंधित है?",
            options = listOf(
                "चार पंक्तियों वाले काव्य रूप से",
                "नाटक से",
                "उपन्यास से",
                "रिपोर्ट से"
            ),
            correctAnswer = 0,
            explanation = "रुबाई चार पंक्तियों का काव्य रूप है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__036",
            question = "औपचारिक पत्र की भाषा कैसी होनी चाहिए?",
            options = listOf(
                "शिष्ट और स्पष्ट",
                "बहुत बोलचाल की",
                "अशिष्ट",
                "अस्पष्ट"
            ),
            correctAnswer = 0,
            explanation = "औपचारिक पत्र में शिष्ट, स्पष्ट और विषयानुकूल भाषा होती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__037",
            question = "विज्ञापन की भाषा सामान्यतः कैसी होती है?",
            options = listOf(
                "संक्षिप्त और आकर्षक",
                "अस्पष्ट",
                "केवल वैज्ञानिक",
                "बहुत लंबी"
            ),
            correctAnswer = 0,
            explanation = "विज्ञापन कम शब्दों में ध्यान आकर्षित करने का प्रयास करता है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__038",
            question = "रिपोर्ट में प्रमुखता होती है:",
            options = listOf(
                "तथ्य और क्रमबद्ध विवरण",
                "केवल कल्पना",
                "केवल संवाद",
                "केवल कविता"
            ),
            correctAnswer = 0,
            explanation = "रिपोर्ट में तथ्यात्मक और क्रमबद्ध प्रस्तुति होती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__039",
            question = "मुहावरा क्या है?",
            options = listOf(
                "विशिष्ट अर्थ देने वाला रूढ़ वाक्यांश",
                "एक अक्षर",
                "केवल संज्ञा",
                "विराम चिन्ह"
            ),
            correctAnswer = 0,
            explanation = "मुहावरा रूढ़ प्रयोग से विशेष अर्थ देता है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__040",
            question = "विशेषण किसकी विशेषता बताता है?",
            options = listOf(
                "संज्ञा या सर्वनाम की",
                "केवल क्रिया की",
                "केवल अव्यय की",
                "केवल विराम चिन्ह की"
            ),
            correctAnswer = 0,
            explanation = "विशेषण संज्ञा या सर्वनाम की विशेषता बताता है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__041",
            question = "भाषा का मुख्य उद्देश्य क्या है?",
            options = listOf(
                "विचारों का संप्रेषण",
                "केवल मनोरंजन",
                "केवल लेखन",
                "केवल परीक्षा"
            ),
            correctAnswer = 0,
            explanation = "भाषा का प्रमुख कार्य विचारों और भावों का संप्रेषण है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__042",
            question = "साहित्य का प्रमुख आधार क्या है?",
            options = listOf(
                "जीवन और अनुभव",
                "केवल कल्पना",
                "केवल इतिहास",
                "केवल विज्ञान"
            ),
            correctAnswer = 0,
            explanation = "साहित्य जीवन और मानवीय अनुभवों से जुड़ा है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__043",
            question = "भक्तिन की लेखिका कौन हैं?",
            options = listOf(
                "महादेवी वर्मा",
                "मन्नू भंडारी",
                "कृष्णा सोबती",
                "सुभद्रा कुमारी चौहान"
            ),
            correctAnswer = 0,
            explanation = "भक्तिन महादेवी वर्मा की रचना है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__044",
            question = "बाजार दर्शन में मुख्य विचार किससे जुड़ा है?",
            options = listOf(
                "बाजार और उपभोक्ता मनोवृत्ति",
                "युद्ध",
                "कृषि",
                "खेल"
            ),
            correctAnswer = 0,
            explanation = "रचना बाजार और उपभोक्ता व्यवहार पर विचार करती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__045",
            question = "काले मेघा पानी दे का संबंध किससे है?",
            options = listOf(
                "वर्षा और लोकजीवन",
                "युद्ध",
                "व्यापार",
                "शहर"
            ),
            correctAnswer = 0,
            explanation = "रचना वर्षा और लोकजीवन से जुड़े अनुभव प्रस्तुत करती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__046",
            question = "श्रम-विभाजन और जाति-प्रथा के लेखक कौन हैं?",
            options = listOf(
                "डॉ. भीमराव आंबेडकर",
                "रामचंद्र शुक्ल",
                "प्रेमचंद",
                "हरिशंकर परसाई"
            ),
            correctAnswer = 0,
            explanation = "यह रचना डॉ. बी.आर. आंबेडकर के विचारों से संबंधित है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__047",
            question = "सिल्वर वैडिंग में मुख्यतः किसका चित्रण है?",
            options = listOf(
                "पीढ़ियों के बदलते मूल्य",
                "युद्ध",
                "कृषि",
                "यात्रा"
            ),
            correctAnswer = 0,
            explanation = "कहानी में पारिवारिक और पीढ़ीगत मूल्यों के बदलाव को दिखाया गया है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__048",
            question = "जूझ का केंद्रीय भाव किससे जुड़ा है?",
            options = listOf(
                "शिक्षा और संघर्ष",
                "धन",
                "राजनीति",
                "यात्रा"
            ),
            correctAnswer = 0,
            explanation = "जूझ में शिक्षा पाने की इच्छा और संघर्ष प्रमुख है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__049",
            question = "उपमा अलंकार में सामान्यतः किससे तुलना होती है?",
            options = listOf(
                "जैसे/सा/समान आदि",
                "केवल विरोध",
                "केवल प्रश्न",
                "केवल पुनरावृत्ति"
            ),
            correctAnswer = 0,
            explanation = "उपमा में उपमेय और उपमान की तुलना की जाती है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(
            id = "hindi_class_12__050",
            question = "रूपक अलंकार में:",
            options = listOf(
                "उपमेय पर उपमान का आरोप होता है",
                "केवल प्रश्न होता है",
                "केवल तुक होती है",
                "कोई तुलना नहीं होती"
            ),
            correctAnswer = 0,
            explanation = "रूपक में उपमेय को उपमान के रूप में प्रस्तुत किया जाता है।",
            subjectId = "hindi",
            chapterId = "hindi_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        )
    )
}
