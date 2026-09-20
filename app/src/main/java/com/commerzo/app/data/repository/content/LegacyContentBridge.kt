package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Subject
import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.repository.ChapterRepository
import com.commerzo.app.data.repository.CurriculumCatalog

/**
 * Bridge between the existing curriculum system and
 * the new dynamic-content architecture.
 *
 * IMPORTANT:
 * - ChapterRepository remains unchanged.
 * - CurriculumCatalog remains unchanged.
 * - QuestionRepository remains unchanged.
 *
 * Special handling is added for Class 12 Economics:
 *
 * New content IDs:
 * - MP Board Micro Economics
 * - MP Board Macro Economics
 * - CBSE Indian Economics
 * - CBSE Macro Economics
 *
 * The legacy ChapterRepository still receives
 * the original "economics" subject ID.
 */
object LegacyContentBridge {

    fun getSubjects(
        board: Board,
        classLevel: ClassLevel
    ): List<ContentSubject> {

        val subjects = getLegacySubjects(
            board = board,
            classLevel = classLevel
        )

        return ContentSubjectRegistry.mapSubjects(
            subjects = subjects
        )
    }

    fun getChapters(
        subjectId: String,
        board: Board,
        classLevel: ClassLevel
    ): List<ContentChapter> {

        val legacySubjectId = getLegacySubjectId(
            subjectId = subjectId,
            board = board,
            classLevel = classLevel
        )

        val chapters = ChapterRepository.getChapters(
            subjectId = legacySubjectId,
            board = board,
            classLevel = classLevel
        )

        val mappedChapters = ContentCatalog.chapters(
            source = chapters
        )

        return filterEconomicsChapters(
            chapters = mappedChapters,
            requestedSubjectId = subjectId,
            board = board,
            classLevel = classLevel
        )
    }

    /**
     * Converts new stable content subject IDs back to
     * the legacy IDs expected by ChapterRepository.
     */
    private fun getLegacySubjectId(
        subjectId: String,
        board: Board,
        classLevel: ClassLevel
    ): String {

        if (classLevel != ClassLevel.CLASS_12) {
            return subjectId
        }

        return when (board) {

            Board.MP_BOARD -> {

                when (subjectId) {

                    "mp_board_class_12_economics_micro",
                    "mp_board_class_12_economics_macro" -> {
                        "economics"
                    }

                    else -> subjectId
                }
            }

            Board.CBSE -> {

                when (subjectId) {

                    "cbse_class_12_economics_indian",
                    "cbse_class_12_economics_macro" -> {
                        "economics"
                    }

                    else -> subjectId
                }
            }
        }
    }

    /**
     * Keeps only the chapters belonging to the selected
     * Economics dataset.
     */
    private fun filterEconomicsChapters(
        chapters: List<ContentChapter>,
        requestedSubjectId: String,
        board: Board,
        classLevel: ClassLevel
    ): List<ContentChapter> {

        if (classLevel != ClassLevel.CLASS_12) {
            return chapters
        }

        val isEconomicsRequest =
            requestedSubjectId == "mp_board_class_12_economics_micro" ||
                requestedSubjectId == "mp_board_class_12_economics_macro" ||
                requestedSubjectId == "cbse_class_12_economics_indian" ||
                requestedSubjectId == "cbse_class_12_economics_macro"

        if (!isEconomicsRequest) {
            return chapters
        }

        return chapters.filter { chapter ->

            val mappedEconomicsSubjectId =
                CurriculumContentMapper
                    .getEconomicsSubjectIdForChapter(
                        board = board,
                        classLevel = classLevel,
                        chapterId = chapter.id
                    )

            mappedEconomicsSubjectId == requestedSubjectId
        }
    }

    private fun getLegacySubjects(
        board: Board,
        classLevel: ClassLevel
    ): List<Subject> {

        return CurriculumCatalog
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
