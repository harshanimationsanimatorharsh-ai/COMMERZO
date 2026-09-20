package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentModuleType
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries

/**
 * Temporary local implementation of ContentRepository.
 *
 * This is intentionally kept separate from the repository contract.
 *
 * Later:
 * LocalContentRepository
 *        ↓
 * RemoteContentRepository
 *        ↓
 * ContentRepository
 *
 * The app can then switch from local/static content
 * to backend/CMS content without changing the UI layer.
 */
class LocalContentRepository : ContentRepository {

    override suspend fun getSubjects(
        boardId: String,
        classId: String
    ): List<ContentSubject> {
        return emptyList()
    }

    override suspend fun getChapters(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<ContentChapter> {
        return emptyList()
    }

    override suspend fun getContent(
        boardId: String,
        classId: String,
        subjectId: String,
        chapterId: String
    ): List<ContentItem> {
        return emptyList()
    }

    override suspend fun getPreviousYearPapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<PreviousYearPaper> {
        return emptyList()
    }

    override suspend fun getSamplePapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<SamplePaper> {
        return emptyList()
    }

    override suspend fun getTestSeries(
        boardId: String,
        classId: String,
        subjectId: String?
    ): List<TestSeries> {
        return emptyList()
    }

    override suspend fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule> {
        return listOf(
            ContentModule(
                id = "learning_content",
                type = ContentModuleType.LEARNING_CONTENT,
                title = "Learning Content",
                boardId = boardId,
                classId = classId,
                description = "MCQs, Notes and PDFs"
            ),
            ContentModule(
                id = "previous_year_papers",
                type = ContentModuleType.PREVIOUS_YEAR_PAPERS,
                title = "Previous Year Papers",
                boardId = boardId,
                classId = classId
            ),
            ContentModule(
                id = "sample_papers",
                type = ContentModuleType.SAMPLE_PAPERS,
                title = "Sample Papers",
                boardId = boardId,
                classId = classId
            ),
            ContentModule(
                id = "test_series",
                type = ContentModuleType.TEST_SERIES,
                title = "Test Series",
                boardId = boardId,
                classId = classId
            )
        )
    }
}
