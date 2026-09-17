package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ChapterData
import com.commerzo.app.data.model.ClassLevel

class ChapterRepository {

    fun getChapters(
        subjectId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): List<ChapterData> {

        return when (subjectId) {

            "accountancy" -> listOf(
                ChapterData(
                    "accounting_for_partnership",
                    subjectId,
                    "Accounting for Partnership Firms",
                    1,
                    board,
                    classLevel
                ),
                ChapterData(
                    "accountancy_2",
                    subjectId,
                    "Accounting for Companies",
                    2,
                    board,
                    classLevel
                ),
                ChapterData(
                    "accountancy_3",
                    subjectId,
                    "Analysis of Financial Statements",
                    3,
                    board,
                    classLevel
                ),
                ChapterData(
                    "accountancy_4",
                    subjectId,
                    "Cash Flow Statement",
                    4,
                    board,
                    classLevel
                ),
                ChapterData(
                    "accountancy_5",
                    subjectId,
                    "Computerised Accounting",
                    5,
                    board,
                    classLevel
                )
            )

            "business_studies" -> listOf(
                ChapterData("bst_1", subjectId, "Nature and Significance of Management", 1, board, classLevel),
                ChapterData("bst_2", subjectId, "Principles of Management", 2, board, classLevel),
                ChapterData("bst_3", subjectId, "Business Environment", 3, board, classLevel),
                ChapterData("bst_4", subjectId, "Planning", 4, board, classLevel),
                ChapterData("bst_5", subjectId, "Organising", 5, board, classLevel)
            )

            "economics" -> listOf(
                ChapterData("eco_1", subjectId, "National Income Accounting", 1, board, classLevel),
                ChapterData("eco_2", subjectId, "Money and Banking", 2, board, classLevel),
                ChapterData("eco_3", subjectId, "Determination of Income and Employment", 3, board, classLevel),
                ChapterData("eco_4", subjectId, "Government Budget", 4, board, classLevel),
                ChapterData("eco_5", subjectId, "Balance of Payments", 5, board, classLevel)
            )

            "mathematics" -> listOf(
                ChapterData("math_1", subjectId, "Relations and Functions", 1, board, classLevel),
                ChapterData("math_2", subjectId, "Matrices", 2, board, classLevel),
                ChapterData("math_3", subjectId, "Determinants", 3, board, classLevel),
                ChapterData("math_4", subjectId, "Continuity and Differentiability", 4, board, classLevel),
                ChapterData("math_5", subjectId, "Applications of Derivatives", 5, board, classLevel)
            )

            "english" -> listOf(
                ChapterData("english_1", subjectId, "Reading Skills", 1, board, classLevel),
                ChapterData("english_2", subjectId, "Writing Skills", 2, board, classLevel),
                ChapterData("english_3", subjectId, "Literature", 3, board, classLevel)
            )

            "hindi" -> listOf(
                ChapterData("hindi_1", subjectId, "गद्य खंड", 1, board, classLevel),
                ChapterData("hindi_2", subjectId, "काव्य खंड", 2, board, classLevel),
                ChapterData("hindi_3", subjectId, "लेखन एवं अभिव्यक्ति", 3, board, classLevel)
            )

            else -> emptyList()
        }
    }
}
