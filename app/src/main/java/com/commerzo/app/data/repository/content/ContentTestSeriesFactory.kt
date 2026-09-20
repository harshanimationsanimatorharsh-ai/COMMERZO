package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.TestSeries

/**
 * Factory for creating COMMERZO Test Series definitions.
 *
 * Test Series are kept separate from normal learning content
 * so tests can later be updated from the backend/CMS without
 * requiring an APK update.
 */
object ContentTestSeriesFactory {

    fun create(
        id: String,
        title: String,
        boardId: String,
        classId: String,
        subjectId: String? = null,
        description: String = "",
        totalTests: Int = 0
    ): TestSeries {

        return TestSeries(
            id = id,
            title = title,
            boardId = boardId,
            classId = classId,
            subjectId = subjectId,
            description = description,
            totalTests = totalTests
        )
    }
}
