package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.ChapterData
import com.commerzo.app.data.model.Subject
import com.commerzo.app.data.repository.ChapterRepository

/**
 * Bridge between the existing curriculum system and
 * the new dynamic-content architecture.
 *
 * IMPORTANT:
 * - Does not modify ChapterRepository.
 * - Does not modify CurriculumCatalog.
 * - Does not modify QuestionRepository.
 *
 * It only reads existing curriculum data and exposes it
 * through the new Content models.
 */
object LegacyContentBridge {

    /**
     * Returns existing subjects as ContentSubject models.
     */
    fun getSubjects(
        board: Board,
        classLevel: ClassLevel
    ): List<com.commerzo.app.data.model.content.ContentSubject> {

        val subjects = getLegacySubjects(
            board = board,
            classLevel = classLevel
        )

        return ContentCatalog.subjects(subjects)
    }

    /**
     * Returns existing chapters as ContentChapter models.
     */
    fun getChapters(
        subjectId: String,
        board: Board,
        classLevel: ClassLevel
    ): List<com.commerzo.app.data.model.content.ContentChapter> {

        val chapters = ChapterRepository.getChapters(
            subjectId = subjectId,
            board = board,
            classLevel = classLevel
        )

        return ContentCatalog.chapters(chapters)
    }

    /**
     * Converts the current Subject definitions into
     * the existing Subject model.
     *
     * This keeps the bridge independent from UI code.
     */
    private fun getLegacySubjects(
        board: Board,
        classLevel: ClassLevel
    ): List<Subject> {

        return com.commerzo.app.data.repository.CurriculumCatalog
            .getSubjectDefinitions(
                board = board,
                classLevel = classLevel
            )
            .map { definition ->

                Subject(
                    id = definition.id,
                    name = definition.name,
                    icon = definition.emoji,
                    classLevel = definition.classLevel,
                    board = definition.board
                )
            }
    }
}
