package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries

/**
 * Central content access contract for COMMERZO.
 *
 * Future architecture:
 *
 * UI
 *  ↓
 * ContentRepository
 *  ↓
 * Local Cache
 *  ↓
 * Remote Content API
 *  ↓
 * Backend / CMS / Database
 *
 * This keeps the UI independent from the actual
 * content storage system.
 */
interface ContentRepository {

    /* ---------------------------------------------------------
     * SUBJECTS
     * --------------------------------------------------------- */

    suspend fun getSubjects(
        boardId: String,
        classId: String
    ): List<ContentSubject>

    /* ---------------------------------------------------------
     * CHAPTERS
     * --------------------------------------------------------- */

    suspend fun getChapters(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<ContentChapter>

    /* ---------------------------------------------------------
     * LEARNING CONTENT
     * --------------------------------------------------------- */

    suspend fun getContent(
        boardId: String,
        classId: String,
        subjectId: String,
        chapterId: String
    ): List<ContentItem>

    /* ---------------------------------------------------------
     * PREVIOUS YEAR PAPERS
     * --------------------------------------------------------- */

    suspend fun getPreviousYearPapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<PreviousYearPaper>

    /* ---------------------------------------------------------
     * SAMPLE PAPERS
     * --------------------------------------------------------- */

    suspend fun getSamplePapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<SamplePaper>

    /* ---------------------------------------------------------
     * TEST SERIES
     * --------------------------------------------------------- */

    suspend fun getTestSeries(
        boardId: String,
        classId: String,
        subjectId: String? = null
    ): List<TestSeries>

    /* ---------------------------------------------------------
     * MODULES
     * --------------------------------------------------------- */

    suspend fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule>
}
