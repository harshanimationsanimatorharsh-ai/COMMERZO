package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.Subject
import com.commerzo.app.data.model.content.ContentSubject

/**
 * Registry that exposes curriculum subjects through
 * the new dynamic-content architecture.
 *
 * Existing Subject data is converted into ContentSubject
 * so the current app can gradually migrate without
 * breaking existing functionality.
 */
object ContentSubjectRegistry {

    fun mapSubjects(
        subjects: List<Subject>
    ): List<ContentSubject> {

        return subjects.map { subject ->
            ContentSubjectMapper.map(subject)
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
