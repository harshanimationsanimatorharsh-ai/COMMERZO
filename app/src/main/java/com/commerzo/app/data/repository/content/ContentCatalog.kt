package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.ChapterData
import com.commerzo.app.data.model.Subject
import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentSubject

/**
 * Unified curriculum access layer for COMMERZO.
 *
 * It converts the existing curriculum models into the
 * new dynamic-content models.
 *
 * This layer does not replace ChapterRepository or
 * CurriculumCatalog. It sits above them so the migration
 * can happen safely and gradually.
 */
object ContentCatalog {

    /**
     * Converts existing subjects into dynamic-content subjects.
     */
    fun subjects(
        source: List<Subject>
    ): List<ContentSubject> {

        return ContentSubjectRegistry.mapSubjects(
            subjects = source
        )
    }

    /**
     * Converts existing chapters into dynamic-content chapters.
     */
    fun chapters(
        source: List<ChapterData>
    ): List<ContentChapter> {

        return ContentChapterRegistry.mapChapters(
            chapters = source
        )
    }

    /**
     * Finds a single subject using stable curriculum identity.
     */
    fun findSubject(
        source: List<Subject>,
        subjectId: String,
        boardId: String,
        classId: String
    ): ContentSubject? {

        return ContentSubjectRegistry.findSubject(
            subjects = source,
            subjectId = subjectId,
            boardId = boardId,
            classId = classId
        )
    }

    /**
     * Finds a single chapter using stable curriculum identity.
     */
    fun findChapter(
        source: List<ChapterData>,
        chapterId: String,
        boardId: String,
        classId: String,
        subjectId: String
    ): ContentChapter? {

        return ContentChapterRegistry.findChapter(
            chapters = source,
            chapterId = chapterId,
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }
}
