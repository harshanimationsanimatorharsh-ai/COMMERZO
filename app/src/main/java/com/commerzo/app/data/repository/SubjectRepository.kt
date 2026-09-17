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

        return CurriculumCatalog
            .getSubjectDefinitions(
                board = board,
                classLevel = classLevel
            )
            .map { definition ->

                val chapterCount = chapterRepository
                    .getChapters(
                        subjectId = definition.id,
                        board = board,
                        classLevel = classLevel
                    )
                    .size

                SubjectData(
                    id = definition.id,
                    name = definition.name,
                    emoji = definition.emoji,
                    board = definition.board,
                    classLevel = definition.classLevel,
                    chaptersCount = chapterCount
                )
            }
    }
}
