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

        return when (classLevel) {
            ClassLevel.CLASS_11 -> getClass11Chapters(subjectId, board)
            ClassLevel.CLASS_12 -> getClass12Chapters(subjectId, board)
        }
    }

    private fun getClass11Chapters(
        subjectId: String,
        board: Board
    ): List<ChapterData> {

        return when (subjectId) {

            "accountancy" -> chapters(
                subjectId,
                board,
                ClassLevel.CLASS_11,
                listOf(
                    "Introduction to Accounting",
                    "Theory Base of Accounting",
                    "Recording of Transactions",
                    "Bank Reconciliation Statement",
                    "Trial Balance and Rectification of Errors",
                    "Depreciation, Provisions and Reserves",
                    "Bill of Exchange",
                    "Financial Statements"
                )
            )

            "business_studies" -> chapters(
                subjectId,
                board,
                ClassLevel.CLASS_11,
                listOf(
                    "Nature and Purpose of Business",
                    "Forms of Business Organisation",
                    "Public, Private and Global Enterprises",
                    "Business Services",
                    "Emerging Modes of Business",
                    "Social Responsibility of Business",
                    "Formation of a Company",
                    "Sources of Business Finance",
                    "Small Business",
                    "Internal Trade",
                    "International Business"
                )
            )

            "economics" -> chapters(
                subjectId,
                board,
                ClassLevel.CLASS_11,
                listOf(
                    "Introduction to Economics",
                    "Theory of Consumer Behaviour",
                    "Theory of Demand",
                    "Theory of Production",
                    "Cost and Revenue",
                    "Perfect Competition",
                    "Statistics for Economics",
                    "Collection of Data",
                    "Organisation of Data",
                    "Presentation of Data",
                    "Statistical Measures"
                )
            )

            "mathematics" -> chapters(
                subjectId,
                board,
                ClassLevel.CLASS_11,
                listOf(
                    "Sets",
                    "Relations and Functions",
                    "Trigonometric Functions",
                    "Complex Numbers and Quadratic Equations",
                    "Linear Inequalities",
                    "Permutations and Combinations",
                    "Binomial Theorem",
                    "Sequences and Series",
                    "Straight Lines",
                    "Conic Sections",
                    "Introduction to Three Dimensional Geometry",
                    "Limits and Derivatives",
                    "Statistics",
                    "Probability"
                )
            )

            "english" -> chapters(
                subjectId,
                board,
                ClassLevel.CLASS_11,
                listOf(
                    "Reading Comprehension",
                    "Grammar and Creative Writing",
                    "Hornbill",
                    "Snapshots"
                )
            )

            "hindi" -> chapters(
                subjectId,
                board,
                ClassLevel.CLASS_11,
                listOf(
                    "आरोह",
                    "वितान",
                    "अभिव्यक्ति और माध्यम"
                )
            )

            else -> emptyList()
        }
    }

    private fun getClass12Chapters(
        subjectId: String,
        board: Board
    ): List<ChapterData> {

        return when (subjectId) {

            "accountancy" -> chapters(
                subjectId,
                board,
                ClassLevel.CLASS_12,
                listOf(
                    "Accounting for Partnership Firms",
                    "Accounting for Companies",
                    "Analysis of Financial Statements",
                    "Cash Flow Statement"
                )
            )

            "business_studies" -> chapters(
                subjectId,
                board,
                ClassLevel.CLASS_12,
                listOf(
                    "Nature and Significance of Management",
                    "Principles of Management",
                    "Business Environment",
                    "Planning",
                    "Organising",
                    "Staffing",
                    "Directing",
                    "Controlling",
                    "Financial Management",
                    "Financial Markets",
                    "Marketing Management",
                    "Consumer Protection"
                )
            )

            "economics" -> chapters(
                subjectId,
                board,
                ClassLevel.CLASS_12,
                listOf(
                    "National Income Accounting",
                    "Money and Banking",
                    "Determination of Income and Employment",
                    "Government Budget",
                    "Balance of Payments",
                    "Development Experience and Economic Reforms",
                    "Current Challenges Facing Indian Economy",
                    "Development Experience of India"
                )
            )

            "mathematics" -> chapters(
                subjectId,
                board,
                ClassLevel.CLASS_12,
                listOf(
                    "Relations and Functions",
                    "Inverse Trigonometric Functions",
                    "Matrices",
                    "Determinants",
                    "Continuity and Differentiability",
                    "Application of Derivatives",
                    "Integrals",
                    "Application of Integrals",
                    "Differential Equations",
                    "Vector Algebra",
                    "Three Dimensional Geometry",
                    "Linear Programming",
                    "Probability"
                )
            )

            "english" -> chapters(
                subjectId,
                board,
                ClassLevel.CLASS_12,
                listOf(
                    "Reading Comprehension",
                    "Writing Skills",
                    "Flamingo",
                    "Vistas"
                )
            )

            "hindi" -> chapters(
                subjectId,
                board,
                ClassLevel.CLASS_12,
                listOf(
                    "आरोह",
                    "वितान",
                    "अभिव्यक्ति और माध्यम"
                )
            )

            else -> emptyList()
        }
    }

    private fun chapters(
        subjectId: String,
        board: Board,
        classLevel: ClassLevel,
        titles: List<String>
    ): List<ChapterData> {

        return titles.mapIndexed { index, title ->
            ChapterData(
                id = "${subjectId}_${classLevel.name.lowercase()}_${index + 1}",
                subjectId = subjectId,
                title = title,
                chapterNumber = index + 1,
                board = board,
                classLevel = classLevel
            )
        }
    }
}
