package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries

/**
 * Main manager for COMMERZO dynamic content.
 *
 * UI/ViewModels should eventually communicate with this
 * manager instead of directly accessing repositories.
 *
 * Current flow:
 *
 * UI
 *  ↓
 * ContentManager
 *  ↓
 * ContentDataSource
 *  ↓
 * ContentRepository
 *  ↓
 * LocalContentRepository
 *
 * Future flow:
 *
 * UI
 *  ↓
 * ContentManager
 *  ↓
 * ContentDataSource
 *  ↓
 * Local Cache + Remote API
 *  ↓
 * Backend / CMS
 */
class ContentManager(
    private val dataSource: ContentDataSource =
        ContentDataSourceProvider.getDataSource()
) {

    suspend fun getSubjects(
        boardId: String,
        classId: String
    ): List<ContentSubject> {

        return dataSource.getSubjects(
            boardId = boardId,
            classId = classId
        )
    }

    suspend fun getChapters(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<ContentChapter> {

        return dataSource.getChapters(
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

        return dataSource.getContent(
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

        return dataSource.getPreviousYearPapers(
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

        return dataSource.getSamplePapers(
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

        return dataSource.getTestSeries(
            boardId = boardId,
            classId = classId,
            subjectId = subjectId
        )
    }

    suspend fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule> {

        return dataSource.getModules(
            boardId = boardId,
            classId = classId
        )
    }
}
