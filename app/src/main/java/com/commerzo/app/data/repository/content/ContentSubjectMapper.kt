package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.Subject
import com.commerzo.app.data.model.content.ContentSubject

/**
 * Converts the existing Subject model into the
 * new dynamic-content ContentSubject model.
 *
 * Existing Subject data remains compatible with
 * the new content architecture.
 */
object ContentSubjectMapper {

    fun map(
        subject: Subject
    ): ContentSubject {

        return ContentSubject(
            id = CurriculumContentMapper.getSubjectId(
                board = subject.board,
                classLevel = subject.classLevel,
                subjectId = subject.id
            ),
            name = subject.name,
            emoji = subject.icon,
            boardId = CurriculumContentMapper.getBoardId(
                subject.board
            ),
            classId = CurriculumContentMapper.getClassId(
                subject.classLevel
            )
        )
    }
}
