package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries
import com.commerzo.app.data.remote.content.RemoteContentClientProvider

/**
 * RemoteContentRepository implementation backed by
 * RemoteContentClient.
 *
 * This repository converts RemoteContentResult into
 * the RemoteContentRepository and ContentRepository
 * contracts.
 */
class ApiRemoteContentRepository(
    private val client: RemoteContentClient =
        RemoteContentClientProvider.getClient()
) : RemoteContentRepository, ContentRepository {

    override suspend fun getSubjects(
        boardId: String,
        classId: String
    ): List<ContentSubject> {

        return when (
            val result = client.getSubjects(
                RemoteContentRequest(
                    boardId = boardId,
                    classId = classId
                )
            )
        ) {
            is RemoteContentResult.Success -> result.data
            is RemoteContentResult.Failure -> emptyList()
        }
    }

    override suspend fun getChapters(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<ContentChapter> {

        return when (
            val result = client.getChapters(
                RemoteContentRequest(
                    boardId = boardId,
                    classId = classId,
                    subjectId = subjectId
                )
            )
        ) {
            is RemoteContentResult.Success -> result.data
            is RemoteContentResult.Failure -> emptyList()
        }
    }

    override suspend fun getContent(
        boardId: String,
        classId: String,
        subjectId: String,
        chapterId: String
    ): List<ContentItem> {

        return when (
            val result = client.getContent(
                RemoteContentRequest(
                    boardId = boardId,
                    classId = classId,
                    subjectId = subjectId,
                    chapterId = chapterId
                )
            )
        ) {
            is RemoteContentResult.Success -> result.data
            is RemoteContentResult.Failure -> emptyList()
        }
    }

    override suspend fun getPreviousYearPapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<PreviousYearPaper> {

        return when (
            val result = client.getPreviousYearPapers(
                RemoteContentRequest(
                    boardId = boardId,
                    classId = classId,
                    subjectId = subjectId
                )
            )
        ) {
            is RemoteContentResult.Success -> result.data
            is RemoteContentResult.Failure -> emptyList()
        }
    }

    override suspend fun getSamplePapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<SamplePaper> {

        return when (
            val result = client.getSamplePapers(
                RemoteContentRequest(
                    boardId = boardId,
                    classId = classId,
                    subjectId = subjectId
                )
            )
        ) {
            is RemoteContentResult.Success -> result.data
            is RemoteContentResult.Failure -> emptyList()
        }
    }

    override suspend fun getTestSeries(
        boardId: String,
        classId: String,
        subjectId: String?
    ): List<TestSeries> {

        return when (
            val result = client.getTestSeries(
                RemoteContentRequest(
                    boardId = boardId,
                    classId = classId,
                    subjectId = subjectId
                )
            )
        ) {
            is RemoteContentResult.Success -> result.data
            is RemoteContentResult.Failure -> emptyList()
        }
    }

    override suspend fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule> {

        return when (
            val result = client.getModules(
                RemoteContentRequest(
                    boardId = boardId,
                    classId = classId
                )
            )
        ) {
            is RemoteContentResult.Success -> result.data
            is RemoteContentResult.Failure -> emptyList()
        }
    }
}
