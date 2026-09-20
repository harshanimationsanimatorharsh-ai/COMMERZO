package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries

/**
 * Data-source layer for COMMERZO content.
 *
 * Current implementation delegates to ContentRepository.
 *
 * Later this layer can coordinate:
 * - Local cache
 * - Remote API
 * - CMS/backend
 * - Offline fallback
 *
 * without changing the UI layer.
 */
class ContentDataSource(
    private val repository: ContentRepository =
        ContentRepositoryProvider.getRepository()
) {

    suspend fun getSubjects(
        boardId: String,
        classId: String
    ): List<ContentSubject> {

        return repository.getSubjects(
            boardId = boardId,
            classId = classId
        )
    }

    suspend fun getChapters(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<ContentChapter> {

        return repository.getChapters(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    suspend fun getContent(
        boardId: String,
        classId: String,
        subjectId: String,
        chapterId: String
    ): List<ContentItem> {

        return repository.getContent(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId,
            chapterId = chapterId
        )
    }

    suspend fun getPreviousYearPapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<PreviousYearPaper> {

        return repository.getPreviousYearPapers(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    suspend fun getSamplePapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<SamplePaper> {

        return repository.getSamplePapers(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    suspend fun getTestSeries(
        boardId: String,
        classId: String,
        subjectId: String? = null
    ): List<TestSeries> {

        return repository.getTestSeries(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    suspend fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule> {

        return repository.getModules(
            boardId = boardId,
            classId = classId
        )
    }
}
