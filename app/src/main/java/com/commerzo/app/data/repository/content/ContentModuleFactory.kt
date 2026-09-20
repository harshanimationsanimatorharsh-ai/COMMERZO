package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.ContentModuleType

/**
 * Creates the top-level COMMERZO content modules
 * for a selected board and class.
 *
 * Modules are kept separate from curriculum chapters
 * so that Previous Year Papers, Sample Papers and
 * Test Series can evolve independently.
 */
object ContentModuleFactory {

    fun createModules(
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
                classId = classId,
                description = "Previous year question papers"
            ),

            ContentModule(
                id = "sample_papers",
                type = ContentModuleType.SAMPLE_PAPERS,
                title = "Sample Papers",
                boardId = boardId,
                classId = classId,
                description = "Sample and model papers"
            ),

            ContentModule(
                id = "test_series",
                type = ContentModuleType.TEST_SERIES,
                title = "Test Series",
                boardId = boardId,
                classId = classId,
                description = "Practice and test series"
            )
        )
    }
}
