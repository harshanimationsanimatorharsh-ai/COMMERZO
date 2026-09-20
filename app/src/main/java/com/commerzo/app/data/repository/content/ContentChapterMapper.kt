package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.ChapterData
import com.commerzo.app.data.model.content.ContentChapter

/**
 * Converts the existing ChapterData model into
 * the new dynamic-content ContentChapter model.
 *
 * Existing chapter data remains the source of truth
 * until the remote content system is connected.
 */
object ContentChapterMapper {

    fun map(
        chapter: ChapterData
    ): ContentChapter {

        return ContentChapter(
            id = chapter.id,
            subjectId = mapSubjectId(
                board = chapter.board,
                classLevel = chapter.classLevel,
                subjectId = chapter.subjectId
            ),
            title = chapter.title,
            chapterNumber = chapter.chapterNumber,
            boardId = CurriculumContentMapper.getBoardId(
                chapter.board
            ),
            classId = CurriculumContentMapper.getClassId(
                chapter.classLevel
            )
        )
    }

    private fun mapSubjectId(
        board: Board,
        classLevel: ClassLevel,
        subjectId: String
    ): String {

        return CurriculumContentMapper.getSubjectId(
            board = board,
            classLevel = classLevel,
            subjectId = subjectId
        )
    }
}
