package com.commerzo.app.data.repository.content

/**
 * Creates stable IDs for dynamic COMMERZO content.
 *
 * Stable IDs are important because backend content may change
 * while the identity of a subject, chapter or resource should
 * remain consistent.
 */
object ContentIdFactory {

    fun subjectId(
        boardId: String,
        classId: String,
        subjectId: String
    ): String {

        return "${boardId}_${classId}_${subjectId}"
    }

    fun chapterId(
        boardId: String,
        classId: String,
        subjectId: String,
        chapterId: String
    ): String {

        return "${boardId}_${classId}_${subjectId}_${chapterId}"
    }

    fun contentId(
        boardId: String,
        classId: String,
        subjectId: String,
        chapterId: String,
        contentId: String
    ): String {

        return "${boardId}_${classId}_${subjectId}_${chapterId}_${contentId}"
    }

    fun previousYearPaperId(
        boardId: String,
        classId: String,
        subjectId: String,
        year: Int
    ): String {

        return "${boardId}_${classId}_${subjectId}_previous_year_$year"
    }

    fun samplePaperId(
        boardId: String,
        classId: String,
        subjectId: String,
        paperId: String
    ): String {

        return "${boardId}_${classId}_${subjectId}_sample_$paperId"
    }

    fun testSeriesId(
        boardId: String,
        classId: String,
        subjectId: String?,
        seriesId: String
    ): String {

        val subjectPart = subjectId ?: "all_subjects"

        return "${boardId}_${classId}_${subjectPart}_test_series_$seriesId"
    }
}
