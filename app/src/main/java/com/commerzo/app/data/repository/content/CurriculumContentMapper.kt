package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.CurriculumContentIds

/**
 * Maps existing COMMERZO curriculum identities into
 * the dynamic-content architecture.
 *
 * Important:
 * Class 12 Economics is intentionally separated into
 * stable board-specific subject identities.
 *
 * MP Board:
 * - Micro Economics
 * - Macro Economics
 *
 * CBSE:
 * - Indian Economics
 * - Macro Economics
 */
object CurriculumContentMapper {

    fun getBoardId(
        board: Board
    ): String {
        return when (board) {
            Board.MP_BOARD ->
                CurriculumContentIds.MP_BOARD

            Board.CBSE ->
                CurriculumContentIds.CBSE
        }
    }

    fun getClassId(
        classLevel: ClassLevel
    ): String {
        return when (classLevel) {
            ClassLevel.CLASS_11 ->
                CurriculumContentIds.CLASS_11

            ClassLevel.CLASS_12 ->
                CurriculumContentIds.CLASS_12
        }
    }

    /**
     * Returns the stable content subject ID.
     *
     * For normal subjects the original subject ID is retained.
     *
     * Economics requires special handling because the legacy
     * curriculum currently uses "economics" as a single ID.
     */
    fun getSubjectId(
        board: Board,
        classLevel: ClassLevel,
        subjectId: String
    ): String {

        if (
            classLevel != ClassLevel.CLASS_12 ||
            subjectId != "economics"
        ) {
            return subjectId
        }

        return when (board) {

            Board.MP_BOARD ->
                CurriculumContentIds.MP_BOARD_CLASS_12_ECONOMICS_MACRO

            Board.CBSE ->
                CurriculumContentIds.CBSE_CLASS_12_ECONOMICS_MACRO
        }
    }

    /**
     * Maps a legacy Economics chapter ID to its new
     * board-specific Economics subject ID.
     *
     * Legacy MP Board chapter IDs:
     * economics_class_12_micro_1..5
     * economics_class_12_macro_1..6
     *
     * Other Economics chapters remain part of the legacy
     * curriculum until their final content structure is defined.
     */
    fun getEconomicsSubjectIdForChapter(
        board: Board,
        classLevel: ClassLevel,
        chapterId: String
    ): String? {

        if (classLevel != ClassLevel.CLASS_12) {
            return null
        }

        return when (board) {

            Board.MP_BOARD -> {

                when {
                    chapterId.startsWith(
                        "economics_class_12_micro_"
                    ) -> {
                        CurriculumContentIds
                            .MP_BOARD_CLASS_12_ECONOMICS_MICRO
                    }

                    chapterId.startsWith(
                        "economics_class_12_macro_"
                    ) -> {
                        CurriculumContentIds
                            .MP_BOARD_CLASS_12_ECONOMICS_MACRO
                    }

                    else -> null
                }
            }

            Board.CBSE -> {

                when {
                    chapterId.startsWith(
                        "economics_class_12_macro_"
                    ) -> {
                        CurriculumContentIds
                            .CBSE_CLASS_12_ECONOMICS_MACRO
                    }

                    else -> {
                        CurriculumContentIds
                            .CBSE_CLASS_12_ECONOMICS_INDIAN
                    }
                }
            }
        }
    }

    fun toContentSubject(
        board: Board,
        classLevel: ClassLevel,
        subjectId: String,
        name: String,
        emoji: String
    ): ContentSubject {

        return ContentSubject(
            id = getSubjectId(
                board = board,
                classLevel = classLevel,
                subjectId = subjectId
            ),
            name = name,
            emoji = emoji,
            boardId = getBoardId(board),
            classId = getClassId(classLevel)
        )
    }

    fun toContentChapter(
        board: Board,
        classLevel: ClassLevel,
        subjectId: String,
        chapterId: String,
        title: String,
        chapterNumber: Int
    ): ContentChapter {

        val mappedSubjectId =
            if (
                subjectId == "economics" &&
                classLevel == ClassLevel.CLASS_12
            ) {
                getEconomicsSubjectIdForChapter(
                    board = board,
                    classLevel = classLevel,
                    chapterId = chapterId
                ) ?: getSubjectId(
                    board = board,
                    classLevel = classLevel,
                    subjectId = subjectId
                )
            } else {
                getSubjectId(
                    board = board,
                    classLevel = classLevel,
                    subjectId = subjectId
                )
            }

        return ContentChapter(
            id = chapterId,
            subjectId = mappedSubjectId,
            title = title,
            chapterNumber = chapterNumber,
            boardId = getBoardId(board),
            classId = getClassId(classLevel)
        )
    }
}
