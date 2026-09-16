package com.commerzo.app.data.repository

import com.commerzo.app.data.model.ChapterData

class ChapterRepository {

    fun getChapters(subjectId: String): List<ChapterData> {

        return when (subjectId) {

            "accountancy" -> listOf(
                ChapterData(
                    "accountancy_1",
                    subjectId,
                    "Accounting for Partnership Firms",
                    1
                ),
                ChapterData(
                    "accountancy_2",
                    subjectId,
                    "Reconstitution of Partnership",
                    2
                ),
                ChapterData(
                    "accountancy_3",
                    subjectId,
                    "Admission of a Partner",
                    3
                ),
                ChapterData(
                    "accountancy_4",
                    subjectId,
                    "Retirement and Death of a Partner",
                    4
                ),
                ChapterData(
                    "accountancy_5",
                    subjectId,
                    "Dissolution of Partnership Firm",
                    5
                )
            )

            "business_studies" -> listOf(
                ChapterData(
                    "bst_1",
                    subjectId,
                    "Nature and Significance of Management",
                    1
                ),
                ChapterData(
                    "bst_2",
                    subjectId,
                    "Principles of Management",
                    2
                ),
                ChapterData(
                    "bst_3",
                    subjectId,
                    "Business Environment",
                    3
                ),
                ChapterData(
                    "bst_4",
                    subjectId,
                    "Planning",
                    4
                ),
                ChapterData(
                    "bst_5",
                    subjectId,
                    "Organising",
                    5
                )
            )

            "economics" -> listOf(
                ChapterData(
                    "eco_1",
                    subjectId,
                    "Introduction to Macroeconomics",
                    1
                ),
                ChapterData(
                    "eco_2",
                    subjectId,
                    "National Income Accounting",
                    2
                ),
                ChapterData(
                    "eco_3",
                    subjectId,
                    "Money and Banking",
                    3
                ),
                ChapterData(
                    "eco_4",
                    subjectId,
                    "Determination of Income and Employment",
                    4
                ),
                ChapterData(
                    "eco_5",
                    subjectId,
                    "Government Budget",
                    5
                )
            )

            "mathematics" -> listOf(
                ChapterData(
                    "math_1",
                    subjectId,
                    "Relations and Functions",
                    1
                ),
                ChapterData(
                    "math_2",
                    subjectId,
                    "Inverse Trigonometric Functions",
                    2
                ),
                ChapterData(
                    "math_3",
                    subjectId,
                    "Matrices",
                    3
                ),
                ChapterData(
                    "math_4",
                    subjectId,
                    "Determinants",
                    4
                ),
                ChapterData(
                    "math_5",
                    subjectId,
                    "Continuity and Differentiability",
                    5
                )
            )

            "english" -> listOf(
                ChapterData(
                    "english_1",
                    subjectId,
                    "Reading Skills",
                    1
                ),
                ChapterData(
                    "english_2",
                    subjectId,
                    "Writing Skills",
                    2
                ),
                ChapterData(
                    "english_3",
                    subjectId,
                    "Literature",
                    3
                )
            )

            "hindi" -> listOf(
                ChapterData(
                    "hindi_1",
                    subjectId,
                    "गद्य खंड",
                    1
                ),
                ChapterData(
                    "hindi_2",
                    subjectId,
                    "काव्य खंड",
                    2
                ),
                ChapterData(
                    "hindi_3",
                    subjectId,
                    "लेखन कौशल",
                    3
                )
            )

            else -> emptyList()
        }
    }
}
