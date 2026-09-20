package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper

/**
 * Factory for paper-based content.
 *
 * Previous Year Papers and Sample Papers are intentionally
 * separate modules in COMMERZO.
 */
object ContentPaperFactory {

    fun createPreviousYearPaper(
        id: String,
        title: String,
        boardId: String,
        classId: String,
        subjectId: String,
        year: Int,
        pdfUrl: String? = null
    ): PreviousYearPaper {

        return PreviousYearPaper(
            id = id,
            title = title,
            boardId = boardId,
            classId = classId,
            subjectId = subjectId,
            year = year,
            pdfUrl = pdfUrl
        )
    }

    fun createSamplePaper(
        id: String,
        title: String,
        boardId: String,
        classId: String,
        subjectId: String,
        pdfUrl: String? = null
    ): SamplePaper {

        return SamplePaper(
            id = id,
            title = title,
            boardId = boardId,
            classId = classId,
            subjectId = subjectId,
            pdfUrl = pdfUrl
        )
    }
}
