package com.commerzo.app.data.remote.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries
import com.commerzo.app.data.repository.content.LocalContentRepository

/**
 * Temporary local implementation of RemoteContentApi.
 *
 * This keeps the API layer functional before the real backend is connected.
 * Later this class can be replaced by a real HTTP implementation without
 * changing the rest of the content architecture.
 */
class LocalRemoteContentApi : RemoteContentApi {

    private val repository = LocalContentRepository()

    override suspend fun getSubjects(
        boardId: String,
        classId: String
    ): List<ContentSubject> {
        return repository.getSubjects(
            boardId = boardId,
            classId = classId
        )
    }

    override suspend fun getChapters(
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

    override suspend fun getContent(
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

    override suspend fun getPreviousYearPapers(
        boardId: String,
        classId: String,
        subjectId: String?
    ): List<PreviousYearPaper> {
        return repository.getPreviousYearPapers(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId.orEmpty()
        )
    }

    override suspend fun getSamplePapers(
        boardId: String,
        classId: String,
        subjectId: String?
    ): List<SamplePaper> {
        return repository.getSamplePapers(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId.orEmpty()
        )
    }

    override suspend fun getTestSeries(
        boardId: String,
        classId: String,
        subjectId: String?
    ): List<TestSeries> {
        return repository.getTestSeries(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    override suspend fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule> {
        return repository.getModules(
            boardId = boardId,
            classId = classId
        )
    }
}
