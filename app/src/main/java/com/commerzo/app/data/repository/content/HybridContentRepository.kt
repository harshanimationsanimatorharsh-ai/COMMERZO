package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries

/**
 * Hybrid content repository for COMMERZO.
 *
 * Current architecture:
 *
 * UI
 *  ↓
 * ContentManager
 *  ↓
 * ContentDataSource
 *  ↓
 * HybridContentRepository
 *  ├── RemoteContentRepository
 *  └── LocalContentRepository
 *
 * Future behaviour:
 * 1. Try remote content.
 * 2. If remote content is unavailable, use local/cache data.
 *
 * This allows COMMERZO to remain usable while the backend
 * is unavailable.
 */
class HybridContentRepository(
    private val remoteRepository: RemoteContentRepository =
        ApiRemoteContentRepository(),
    private val localRepository: ContentRepository =
        LocalContentRepository()
) : ContentRepository {

    override suspend fun getSubjects(
        boardId: String,
        classId: String
    ): List<ContentSubject> {

        val remoteData = remoteRepository.getSubjects(
            boardId = boardId,
            classId = classId
        )

        return if (remoteData.isNotEmpty()) {
            remoteData
        } else {
            localRepository.getSubjects(
                boardId = boardId,
                classId = classId
            )
        }
    }

    override suspend fun getChapters(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<ContentChapter> {

        val remoteData = remoteRepository.getChapters(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )

        return if (remoteData.isNotEmpty()) {
            remoteData
        } else {
            localRepository.getChapters(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        }
    }

    override suspend fun getContent(
        boardId: String,
        classId: String,
        subjectId: String,
        chapterId: String
    ): List<ContentItem> {

        val remoteData = remoteRepository.getContent(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId,
            chapterId = chapterId
        )

        return if (remoteData.isNotEmpty()) {
            remoteData
        } else {
            localRepository.getContent(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId,
                chapterId = chapterId
            )
        }
    }

    override suspend fun getPreviousYearPapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<PreviousYearPaper> {

        val remoteData = remoteRepository.getPreviousYearPapers(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )

        return if (remoteData.isNotEmpty()) {
            remoteData
        } else {
            localRepository.getPreviousYearPapers(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        }
    }

    override suspend fun getSamplePapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<SamplePaper> {

        val remoteData = remoteRepository.getSamplePapers(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )

        return if (remoteData.isNotEmpty()) {
            remoteData
        } else {
            localRepository.getSamplePapers(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        }
    }

    override suspend fun getTestSeries(
        boardId: String,
        classId: String,
        subjectId: String?
    ): List<TestSeries> {

        val remoteData = remoteRepository.getTestSeries(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )

        return if (remoteData.isNotEmpty()) {
            remoteData
        } else {
            localRepository.getTestSeries(
                boardId = boardId,
                classId = classId,
                subjectId = subjectId
            )
        }
    }

    override suspend fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule> {

        val remoteData = remoteRepository.getModules(
            boardId = boardId,
            classId = classId
        )

        return if (remoteData.isNotEmpty()) {
            remoteData
        } else {
            localRepository.getModules(
                boardId = boardId,
                classId = classId
            )
        }
    }
}
