package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries
import com.commerzo.app.data.remote.content.RemoteContentClientProvider

class ApiRemoteContentRepository(
    private val client: RemoteContentClient = RemoteContentClientProvider.getClient()
) : ContentRepository {

    override suspend fun getSubjects(
        boardId: String,
        classId: String
    ): List<ContentSubject> {
        return client.getSubjects(
            RemoteContentRequest(
                boardId = boardId,
                classId = classId
            )
        ).getOrElse { emptyList() }
    }

    override suspend fun getChapters(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<ContentChapter> {
        return client.getChapters(
            RemoteContentRequest(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        ).getOrElse { emptyList() }
    }

    override suspend fun getContent(
        boardId: String,
        classId: String,
        subjectId: String,
        chapterId: String
    ): List<ContentItem> {
        return client.getContent(
            RemoteContentRequest(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId,
                chapterId = chapterId
            )
        ).getOrElse { emptyList() }
    }

    override suspend fun getPreviousYearPapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<PreviousYearPaper> {
        return client.getPreviousYearPapers(
            RemoteContentRequest(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        ).getOrElse { emptyList() }
    }

    override suspend fun getSamplePapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<SamplePaper> {
        return client.getSamplePapers(
            RemoteContentRequest(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        ).getOrElse { emptyList() }
    }

    override suspend fun getTestSeries(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<TestSeries> {
        return client.getTestSeries(
            RemoteContentRequest(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        ).getOrElse { emptyList() }
    }

    override suspend fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule> {
        return client.getModules(
            RemoteContentRequest(
                boardId = boardId,
                classId = classId
            )
        ).getOrElse { emptyList() }
    }
}
