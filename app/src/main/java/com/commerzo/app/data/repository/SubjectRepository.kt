package com.commerzo.app.data.repository

import com.commerzo.app.data.model.SubjectData

class SubjectRepository {

    fun getSubjects(
        board: String = "MP_BOARD",
        classLevel: String = "CLASS_12"
    ): List<SubjectData> {

        return listOf(
            SubjectData(
                id = "accountancy",
                name = "Accountancy",
                emoji = "📊",
                board = board,
                classLevel = classLevel,
                chaptersCount = 5
            ),
            SubjectData(
                id = "business_studies",
                name = "Business Studies",
                emoji = "💼",
                board = board,
                classLevel = classLevel,
                chaptersCount = 5
            ),
            SubjectData(
                id = "economics",
                name = "Economics",
                emoji = "📈",
                board = board,
                classLevel = classLevel,
                chaptersCount = 5
            ),
            SubjectData(
                id = "mathematics",
                name = "Mathematics",
                emoji = "🧮",
                board = board,
                classLevel = classLevel,
                chaptersCount = 5
            ),
            SubjectData(
                id = "english",
                name = "English",
                emoji = "📖",
                board = board,
                classLevel = classLevel,
                chaptersCount = 3
            ),
            SubjectData(
                id = "hindi",
                name = "Hindi",
                emoji = "📝",
                board = board,
                classLevel = classLevel,
                chaptersCount = 3
            )
        )
    }
}
