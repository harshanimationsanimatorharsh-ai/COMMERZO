package com.commerzo.app.data.remote.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries

class LocalRemoteContentClient : RemoteContentClient {

    private val networkClient: NetworkContentClient by lazy {
        NetworkContentClientProvider.getClient()
    }

    override suspend fun getSubjects(
        boardId: String,
        classId: String
    ): RemoteContentResult<List<ContentSubject>> {
        return RemoteContentResult.Success(
            networkClient.getSubjects(boardId, classId)
        )
    }

    override suspend fun getChapters(
        boardId: String,
        classId: String,
        subjectId: String
    ): RemoteContentResult<List<ContentChapter>> {
        return RemoteContentResult.Success(
            networkClient.getChapters(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        )
    }

    override suspend fun getContent(
        boardId: String,
        classId: String,
        subjectId: String,
        chapterId: String
    ): RemoteContentResult<List<ContentItem>> {
        return RemoteContentResult.Success(
            networkClient.getContent(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId,
                chapterId = chapterId
            )
        )
    }

    override suspend fun getPreviousYearPapers(
        boardId: String,
        classId: String,
        subjectId: String?
    ): RemoteContentResult<List<PreviousYearPaper>> {
        return RemoteContentResult.Success(
            networkClient.getPreviousYearPapers(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        )
    }

    override suspend fun getSamplePapers(
        boardId: String,
        classId: String,
        subjectId: String?
    ): RemoteContentResult<List<SamplePaper>> {
        return RemoteContentResult.Success(
            networkClient.getSamplePapers(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        )
    }

    override suspend fun getTestSeries(
        boardId: String,
        classId: String,
        subjectId: String?
    ): RemoteContentResult<List<TestSeries>> {
        return RemoteContentResult.Success(
            networkClient.getTestSeries(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        )
    }

    override suspend fun getModules(
        boardId: String,
        classId: String
    ): RemoteContentResult<List<ContentModule>> {
        return RemoteContentResult.Success(
            networkClient.getModules(boardId, classId)
        )
    }
}
