package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Subject
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.CurriculumContentIds

/**
 * Registry that exposes curriculum subjects through
 * the dynamic-content architecture.
 *
 * Special handling:
 *
 * Class 12 MP Board Economics:
 * - Micro Economics
 * - Macro Economics
 *
 * Class 12 CBSE Economics:
 * - Indian Economics
 * - Macro Economics
 *
 * These are exposed as separate subjects so their
 * backend datasets can remain completely independent.
 */
object ContentSubjectRegistry {

    fun mapSubjects(
        subjects: List<Subject>
    ): List<ContentSubject> {

        val result = mutableListOf<ContentSubject>()

        subjects.forEach { subject ->

            if (
                subject.id == "economics" &&
                subject.classLevel == ClassLevel.CLASS_12
            ) {

                when (subject.board) {

                    Board.MP_BOARD -> {

                        result += ContentSubject(
                            id = CurriculumContentIds
                                .MP_BOARD_CLASS_12_ECONOMICS_MICRO,
                            name = "Micro Economics",
                            emoji = "📈",
                            boardId = CurriculumContentMapper
                                .getBoardId(subject.board),
                            classId = CurriculumContentMapper
                                .getClassId(subject.classLevel)
                        )

                        result += ContentSubject(
                            id = CurriculumContentIds
                                .MP_BOARD_CLASS_12_ECONOMICS_MACRO,
                            name = "Macro Economics",
                            emoji = "📊",
                            boardId = CurriculumContentMapper
                                .getBoardId(subject.board),
                            classId = CurriculumContentMapper
                                .getClassId(subject.classLevel)
                        )
                    }

                    Board.CBSE -> {

                        result += ContentSubject(
                            id = CurriculumContentIds
                                .CBSE_CLASS_12_ECONOMICS_INDIAN,
                            name = "Indian Economics",
                            emoji = "🇮🇳",
                            boardId = CurriculumContentMapper
                                .getBoardId(subject.board),
                            classId = CurriculumContentMapper
                                .getClassId(subject.classLevel)
                        )

                        result += ContentSubject(
                            id = CurriculumContentIds
                                .CBSE_CLASS_12_ECONOMICS_MACRO,
                            name = "Macro Economics",
                            emoji = "📊",
                            boardId = CurriculumContentMapper
                                .getBoardId(subject.board),
                            classId = CurriculumContentMapper
                                .getClassId(subject.classLevel)
                        )
                    }
                }

            } else {

                result += ContentSubjectMapper.map(
                    subject
                )
            }
        }

        return result.distinctBy { subject ->
            subject.id
        }
    }

    fun findSubject(
        subjects: List<Subject>,
        subjectId: String,
        boardId: String,
        classId: String
    ): ContentSubject? {

        return mapSubjects(subjects).firstOrNull { subject ->

            subject.id == subjectId &&
                subject.boardId == boardId &&
                subject.classId == classId
        }
    }
}
