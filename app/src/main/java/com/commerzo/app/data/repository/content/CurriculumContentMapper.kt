package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.CurriculumContentIds

/**
 * Maps the existing COMMERZO curriculum identity
 * to the new dynamic-content architecture.
 *
 * This layer does not contain MCQs, notes or PDFs.
 * It only creates stable curriculum identities.
 */
object CurriculumContentMapper {

    /* ---------------------------------------------------------
     * BOARD
     * --------------------------------------------------------- */

    fun getBoardId(
        board: Board
    ): String {

        return when (board) {
            Board.MP_BOARD -> CurriculumContentIds.MP_BOARD
            Board.CBSE -> CurriculumContentIds.CBSE
        }
    }

    /* ---------------------------------------------------------
     * CLASS
     * --------------------------------------------------------- */

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

    /* ---------------------------------------------------------
     * SUBJECT ID
     * --------------------------------------------------------- */

    fun getSubjectId(
        board: Board,
        classLevel: ClassLevel,
        subjectId: String
    ): String {

        return when {

            board == Board.MP_BOARD &&
                classLevel == ClassLevel.CLASS_12 &&
                subjectId == "economics" -> {

                /*
                 * Economics is intentionally NOT mapped to
                 * one generic ID for the new architecture.
                 *
                 * Micro and Macro remain separate datasets.
                 *
                 * The actual selection between Micro and Macro
                 * will happen from the chapter/content layer.
                 */
                "economics"
            }

            board == Board.CBSE &&
                classLevel == ClassLevel.CLASS_12 &&
                subjectId == "economics" -> {

                /*
                 * CBSE Economics will later be split into:
                 *
                 * Indian Economics
                 * Macro Economics
                 */
                "economics"
            }

            else -> subjectId
        }
    }

    /* ---------------------------------------------------------
     * CONTENT SUBJECT
     * --------------------------------------------------------- */

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

    /* ---------------------------------------------------------
     * CONTENT CHAPTER
     * --------------------------------------------------------- */

    fun toContentChapter(
        board: Board,
        classLevel: ClassLevel,
        subjectId: String,
        chapterId: String,
        title: String,
        chapterNumber: Int
    ): ContentChapter {

        return ContentChapter(
            id = chapterId,
            subjectId = getSubjectId(
                board = board,
                classLevel = classLevel,
                subjectId = subjectId
            ),
            title = title,
            chapterNumber = chapterNumber,
            boardId = getBoardId(board),
            classId = getClassId(classLevel)
        )
    }
}
