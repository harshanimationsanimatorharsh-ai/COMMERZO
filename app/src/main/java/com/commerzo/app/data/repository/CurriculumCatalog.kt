package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel

data class CurriculumSubjectDefinition(
    val id: String,
    val name: String,
    val emoji: String,
    val board: Board,
    val classLevel: ClassLevel
)

object CurriculumCatalog {

    fun getSubjectDefinitions(
        board: Board,
        classLevel: ClassLevel
    ): List<CurriculumSubjectDefinition> {

        return when (board) {

            Board.CBSE -> getCbseSubjects(classLevel)

            Board.MP_BOARD -> getMpBoardSubjects(classLevel)
        }
    }

    private fun getCbseSubjects(
        classLevel: ClassLevel
    ): List<CurriculumSubjectDefinition> {

        return commonSubjects(
            board = Board.CBSE,
            classLevel = classLevel
        )
    }

    private fun getMpBoardSubjects(
        classLevel: ClassLevel
    ): List<CurriculumSubjectDefinition> {

        return commonSubjects(
            board = Board.MP_BOARD,
            classLevel = classLevel
        )
    }

    private fun commonSubjects(
        board: Board,
        classLevel: ClassLevel
    ): List<CurriculumSubjectDefinition> {

        return listOf(
            CurriculumSubjectDefinition(
                id = "accountancy",
                name = "Accountancy",
                emoji = "📊",
                board = board,
                classLevel = classLevel
            ),
            CurriculumSubjectDefinition(
                id = "business_studies",
                name = "Business Studies",
                emoji = "💼",
                board = board,
                classLevel = classLevel
            ),
            CurriculumSubjectDefinition(
                id = "economics",
                name = "Economics",
                emoji = "📈",
                board = board,
                classLevel = classLevel
            ),
            CurriculumSubjectDefinition(
                id = "mathematics",
                name = "Mathematics",
                emoji = "🧮",
                board = board,
                classLevel = classLevel
            ),
            CurriculumSubjectDefinition(
                id = "english",
                name = "English",
                emoji = "📖",
                board = board,
                classLevel = classLevel
            ),
            CurriculumSubjectDefinition(
                id = "hindi",
                name = "Hindi",
                emoji = "📝",
                board = board,
                classLevel = classLevel
            )
        )
    }
}
