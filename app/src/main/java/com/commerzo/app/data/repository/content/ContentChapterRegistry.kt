package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.ChapterData
import com.commerzo.app.data.model.content.ContentChapter

/**
 * Registry for exposing existing chapter data through
 * the new dynamic-content architecture.
 */
object ContentChapterRegistry {

    fun mapChapters(
        chapters: List<ChapterData>
    ): List<ContentChapter> {

        return chapters.map { chapter ->
            ContentChapterMapper.map(chapter)
        }
    }

    fun findChapter(
        chapters: List<ChapterData>,
        chapterId: String,
        boardId: String,
        classId: String,
        subjectId: String
    ): ContentChapter? {

        return mapChapters(chapters).firstOrNull { chapter ->

            chapter.id == chapterId &&
                chapter.boardId == boardId &&
                chapter.classId == classId &&
                chapter.subjectId == subjectId
        }
    }
}
