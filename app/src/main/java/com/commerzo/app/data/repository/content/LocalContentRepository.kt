package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentModuleType
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries

/**
 * Local implementation of ContentRepository.
 *
 * Current role:
 * - Uses existing curriculum data already present in COMMERZO.
 * - Keeps new dynamic-content models separate.
 * - Does not modify QuestionRepository.
 *
 * Future role:
 * - Can be combined with a local cache.
 * - Remote content can later be fetched and cached without
 *   changing the ContentRepository interface.
 */
class LocalContentRepository : ContentRepository {

    /* ---------------------------------------------------------
     * SUBJECTS
     * --------------------------------------------------------- */

    override suspend fun getSubjects(
        boardId: String,
        classId: String
    ): List<ContentSubject> {

        val board = when (boardId) {
            "mp_board" -> Board.MP_BOARD
            "cbse" -> Board.CBSE
            else -> return emptyList()
        }

        val classLevel = when (classId) {
            "class_11" -> ClassLevel.CLASS_11
            "class_12" -> ClassLevel.CLASS_12
            else -> return emptyList()
        }

        return LegacyContentBridge.getSubjects(
            board = board,
            classLevel = classLevel
        )
    }

    /* ---------------------------------------------------------
     * CHAPTERS
     * --------------------------------------------------------- */

    override suspend fun getChapters(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<ContentChapter> {

        val board = when (boardId) {
            "mp_board" -> Board.MP_BOARD
            "cbse" -> Board.CBSE
            else -> return emptyList()
        }

        val classLevel = when (classId) {
            "class_11" -> ClassLevel.CLASS_11
            "class_12" -> ClassLevel.CLASS_12
            else -> return emptyList()
        }

        return LegacyContentBridge.getChapters(
            subjectId = subjectId,
            board = board,
            classLevel = classLevel
        )
    }

    /* ---------------------------------------------------------
     * LEARNING CONTENT
     * --------------------------------------------------------- */

    override suspend fun getContent(
        boardId: String,
        classId: String,
        subjectId: String,
        chapterId: String
    ): List<ContentItem> {

        /*
         * MCQ/Notes/PDF content will be connected here
         * after the content storage layer is introduced.
         *
         * QuestionRepository is intentionally NOT modified
         * in this step.
         */
        return emptyList()
    }

    /* ---------------------------------------------------------
     * PREVIOUS YEAR PAPERS
     * --------------------------------------------------------- */

    override suspend fun getPreviousYearPapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<PreviousYearPaper> {

        /*
         * Previous-year paper storage will be connected
         * through the future backend/content layer.
         */
        return emptyList()
    }

    /* ---------------------------------------------------------
     * SAMPLE PAPERS
     * --------------------------------------------------------- */

    override suspend fun getSamplePapers(
        boardId: String,
        classId: String,
        subjectId: String
    ): List<SamplePaper> {

        /*
         * Sample-paper storage will be connected later.
         */
        return emptyList()
    }

    /* ---------------------------------------------------------
     * TEST SERIES
     * --------------------------------------------------------- */

    override suspend fun getTestSeries(
        boardId: String,
        classId: String,
        subjectId: String?
    ): List<TestSeries> {

        /*
         * Test Series remains a separate module.
         */
        return emptyList()
    }

    /* ---------------------------------------------------------
     * MODULES
     * --------------------------------------------------------- */

    override suspend fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule> {

        return ContentModuleFactory.createModules(
            boardId = boardId,
            classId = classId
        ).filter { module ->

            when (module.type) {

                ContentModuleType.LEARNING_CONTENT,
                ContentModuleType.PREVIOUS_YEAR_PAPERS,
                ContentModuleType.SAMPLE_PAPERS,
                ContentModuleType.TEST_SERIES -> true
            }
        }
    }
}
