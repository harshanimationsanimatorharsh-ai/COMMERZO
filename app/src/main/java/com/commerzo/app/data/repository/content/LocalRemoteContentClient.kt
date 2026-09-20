package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries

/**
 * Local fallback implementation of RemoteContentClient.
 *
 * IMPORTANT:
 * This class does not perform network requests.
 *
 * It currently delegates to LocalContentRepository so the
 * remote architecture can be developed safely before the
 * real backend/API is connected.
 *
 * Later this implementation can be replaced by a real
 * HTTP/API client without changing ContentManager.
 */
class LocalRemoteContentClient(
    private val localRepository: ContentRepository =
        LocalContentRepository()
) : RemoteContentClient {

    override suspend fun getSubjects(
        request: RemoteContentRequest
    ): RemoteContentResult<List<ContentSubject>> {

        return RemoteContentResult.Success(
            localRepository.getSubjects(
                boardId = request.boardId,
                classId = request.classId
            )
        )
    }

    override suspend fun getChapters(
        request: RemoteContentRequest
    ): RemoteContentResult<List<ContentChapter>> {

        val subjectId = request.subjectId
            ?: return RemoteContentResult.Failure(
                RemoteContentError.InvalidResponse
            )

        return RemoteContentResult.Success(
            localRepository.getChapters(
                boardId = request.boardId,
                classId = request.classId,
                subjectId = subjectId
            )
        )
    }

    override suspend fun getContent(
        request: RemoteContentRequest
    ): RemoteContentResult<List<ContentItem>> {

        val subjectId = request.subjectId
            ?: return RemoteContentResult.Failure(
                RemoteContentError.InvalidResponse
            )

        val chapterId = request.chapterId
            ?: return RemoteContentResult.Failure(
                RemoteContentError.InvalidResponse
            )

        return RemoteContentResult.Success(
            localRepository.getContent(
                boardId = request.boardId,
                classId = request.classId,
                subjectId = subjectId,
                chapterId = chapterId
            )
        )
    }

    override suspend fun getPreviousYearPapers(
        request: RemoteContentRequest
    ): RemoteContentResult<List<PreviousYearPaper>> {

        val subjectId = request.subjectId
            ?: return RemoteContentResult.Failure(
                RemoteContentError.InvalidResponse
            )

        return RemoteContentResult.Success(
            localRepository.getPreviousYearPapers(
                boardId = request.boardId,
                classId = request.classId,
                subjectId = subjectId
            )
        )
    }

    override suspend fun getSamplePapers(
        request: RemoteContentRequest
    ): RemoteContentResult<List<SamplePaper>> {

        val subjectId = request.subjectId
            ?: return RemoteContentResult.Failure(
                RemoteContentError.InvalidResponse
            )

        return RemoteContentResult.Success(
            localRepository.getSamplePapers(
                boardId = request.boardId,
                classId = request.classId,
                subjectId = subjectId
            )
        )
    }

    override suspend fun getTestSeries(
        request: RemoteContentRequest
    ): RemoteContentResult<List<TestSeries>> {

        return RemoteContentResult.Success(
            localRepository.getTestSeries(
                boardId = request.boardId,
                classId = request.classId,
                subjectId = request.subjectId
            )
        )
    }

    override suspend fun getModules(
        request: RemoteContentRequest
    ): RemoteContentResult<List<ContentModule>> {

        return RemoteContentResult.Success(
            localRepository.getModules(
                boardId = request.boardId,
                classId = request.classId
            )
        )
    }
}
