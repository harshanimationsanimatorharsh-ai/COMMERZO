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

    private val subjects = listOf(
        "accountancy" to "Accountancy",
        "business_studies" to "Business Studies",
        "economics" to "Economics",
        "mathematics" to "Mathematics",
        "english" to "English",
        "hindi" to "Hindi"
    )

    fun getSubjectDefinitions(
        board: Board,
        classLevel: ClassLevel
    ): List<CurriculumSubjectDefinition> {

        return subjects.map { (id, name) ->
            CurriculumSubjectDefinition(
                id = id,
                name = name,
                emoji = emojiFor(id),
                board = board,
                classLevel = classLevel
            )
        }
    }

    private fun emojiFor(subjectId: String): String {
        return when (subjectId) {
            "accountancy" -> "📊"
            "business_studies" -> "💼"
            "economics" -> "📈"
            "mathematics" -> "🧮"
            "english" -> "📖"
            "hindi" -> "📝"
            else -> "📚"
        }
    }
}
