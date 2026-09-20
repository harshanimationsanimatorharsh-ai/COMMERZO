package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.ChapterData
import com.commerzo.app.data.model.content.ContentChapter

/**
 * Converts the existing ChapterData model into
 * the new dynamic-content ContentChapter model.
 *
 * Existing ChapterRepository remains unchanged.
 *
 * Economics chapters are mapped to separate stable
 * subject IDs for MP Board and CBSE Class 12.
 */
object ContentChapterMapper {

    fun map(
        chapter: ChapterData
    ): ContentChapter {

        val mappedSubjectId =
            if (
                chapter.subjectId == "economics" &&
                chapter.classLevel.name == "CLASS_12"
            ) {
                CurriculumContentMapper
                    .getEconomicsSubjectIdForChapter(
                        board = chapter.board,
                        classLevel = chapter.classLevel,
                        chapterId = chapter.id
                    )
                    ?: CurriculumContentMapper.getSubjectId(
                        board = chapter.board,
                        classLevel = chapter.classLevel,
                        subjectId = chapter.subjectId
                    )
            } else {
                CurriculumContentMapper.getSubjectId(
                    board = chapter.board,
                    classLevel = chapter.classLevel,
                    subjectId = chapter.subjectId
                )
            }

        return ContentChapter(
            id = chapter.id,
            subjectId = mappedSubjectId,
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
}
