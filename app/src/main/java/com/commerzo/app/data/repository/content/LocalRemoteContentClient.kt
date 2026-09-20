package com.commerzo.app.data.remote.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries
import com.commerzo.app.data.repository.content.RemoteContentClient
import com.commerzo.app.data.repository.content.RemoteContentResult

class LocalRemoteContentClient : RemoteContentClient {

    private val networkClient: NetworkContentClient by lazy {
        NetworkContentClientProvider.getClient()
    }

    override suspend fun getSubjects(
        request: RemoteContentRequest
    ): RemoteContentResult<List<ContentSubject>> {
        return RemoteContentResult.Success(
            networkClient.getSubjects(
                request.boardId,
                request.classId
            )
        )
    }

    override suspend fun getChapters(
        request: RemoteContentRequest
    ): RemoteContentResult<List<ContentChapter>> {
        return RemoteContentResult.Success(
            networkClient.getChapters(
                request.boardId,
                request.classId,
                request.subjectId.orEmpty()
            )
        )
    }

    override suspend fun getContent(
        request: RemoteContentRequest
    ): RemoteContentResult<List<ContentItem>> {
        return RemoteContentResult.Success(
            networkClient.getContent(
                request.boardId,
                request.classId,
                request.subjectId.orEmpty(),
                request.chapterId.orEmpty()
            )
        )
    }

    override suspend fun getPreviousYearPapers(
        request: RemoteContentRequest
    ): RemoteContentResult<List<PreviousYearPaper>> {
        return RemoteContentResult.Success(
            networkClient.getPreviousYearPapers(
                request.boardId,
                request.classId,
                request.subjectId
            )
        )
    }

    override suspend fun getSamplePapers(
        request: RemoteContentRequest
    ): RemoteContentResult<List<SamplePaper>> {
        return RemoteContentResult.Success(
            networkClient.getSamplePapers(
                request.boardId,
                request.classId,
                request.subjectId
            )
        )
    }

    override suspend fun getTestSeries(
        request: RemoteContentRequest
    ): RemoteContentResult<List<TestSeries>> {
        return RemoteContentResult.Success(
            networkClient.getTestSeries(
                request.boardId,
                request.classId,
                request.subjectId
            )
        )
    }

    override suspend fun getModules(
        request: RemoteContentRequest
    ): RemoteContentResult<List<ContentModule>> {
        return RemoteContentResult.Success(
            networkClient.getModules(
                request.boardId,
                request.classId
            )
        )
    }
}
