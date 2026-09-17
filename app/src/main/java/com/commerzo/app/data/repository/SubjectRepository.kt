package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.SubjectData

class SubjectRepository {

    private val chapterRepository = ChapterRepository()

    fun getSubjects(
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): List<SubjectData> {

        val subjectDefinitions = listOf(
            Triple("accountancy", "Accountancy", "📊"),
            Triple("business_studies", "Business Studies", "💼"),
            Triple("economics", "Economics", "📈"),
            Triple("mathematics", "Mathematics", "🧮"),
            Triple("english", "English", "📖"),
            Triple("hindi", "Hindi", "📝")
        )

        return subjectDefinitions.map { (id, name, emoji) ->

            val chapterCount = chapterRepository
                .getChapters(
                    subjectId = id,
                    board = board,
                    classLevel = classLevel
                )
                .size

            SubjectData(
                id = id,
                name = name,
                emoji = emoji,
                board = board,
                classLevel = classLevel,
                chaptersCount = chapterCount
            )
        }
    }
}
