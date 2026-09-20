package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries

/**
 * Remote content contract for COMMERZO.
 *
 * This interface defines the data that will eventually
 * come from the COMMERZO backend/API.
 *
 * No networking dependency is used here.
 * The actual HTTP/API implementation will be added later.
 *
 * This allows:
 *
 * UI
 *  ↓
 * ContentManager
 *  ↓
 * ContentDataSource
 *  ↓
 * ContentRepository
 *  ↓
 * RemoteContentRepository
 *  ↓
 * Backend / CMS / Database
 */
interface RemoteContentRepository {

    suspend fun getSubjects(
        boardId: String,
        classId: String
    ): List<ContentSubject>

    suspend fun getChapters(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<ContentChapter>

    suspend fun getContent(
        boardId: String,
        classId: String,
        subjectId: String,
        chapterId: String
    ): List<ContentItem>

    suspend fun getPreviousYearPapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<PreviousYearPaper>

    suspend fun getSamplePapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<SamplePaper>

    suspend fun getTestSeries(
        boardId: String,
        classId: String,
        subjectId: String? = null
    ): List<TestSeries>

    suspend fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule>
}
