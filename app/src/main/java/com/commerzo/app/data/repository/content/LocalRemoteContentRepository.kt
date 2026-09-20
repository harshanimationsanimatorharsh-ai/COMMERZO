package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries

/**
 * Temporary remote-compatible implementation.
 *
 * IMPORTANT:
 * This is NOT the real network implementation yet.
 *
 * It currently falls back to the existing local content
 * system so that enabling the remote architecture does
 * not break the application.
 *
 * Later this class can be replaced by an actual API-backed
 * implementation without changing ContentManager.
 */
class LocalRemoteContentRepository(
    private val localRepository: ContentRepository =
        LocalContentRepository()
) : RemoteContentRepository {

    override suspend fun getSubjects(
        boardId: String,
        classId: String
    ): List<ContentSubject> {
        return localRepository.getSubjects(
            boardId = boardId,
            classId = classId
        )
    }

    override suspend fun getChapters(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<ContentChapter> {
        return localRepository.getChapters(
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
        return localRepository.getContent(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId,
            chapterId = chapterId
        )
    }

    override suspend fun getPreviousYearPapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<PreviousYearPaper> {
        return localRepository.getPreviousYearPapers(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    override suspend fun getSamplePapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<SamplePaper> {
        return localRepository.getSamplePapers(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    override suspend fun getTestSeries(
        boardId: String,
        classId: String,
        subjectId: String?
    ): List<TestSeries> {
        return localRepository.getTestSeries(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    override suspend fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule> {
        return localRepository.getModules(
            boardId = boardId,
            classId = classId
        )
    }
}
