package com.commerzo.app.data.model.content

/**
 * Root content hierarchy:
 *
 * Board
 *   -> Class
 *      -> Subject
 *         -> Chapter
 *            -> Content
 *
 * Separate modules:
 *   -> Previous Year Papers
 *   -> Sample Papers
 *   -> Test Series
 */

/* ---------------------------------------------------------
 * SUBJECT
 * --------------------------------------------------------- */

data class ContentSubject(
    val id: String,
    val name: String,
    val emoji: String,
    val boardId: String,
    val classId: String
)

/* ---------------------------------------------------------
 * CHAPTER
 * --------------------------------------------------------- */

data class ContentChapter(
    val id: String,
    val subjectId: String,
    val title: String,
    val chapterNumber: Int,
    val boardId: String,
    val classId: String
)

/* ---------------------------------------------------------
 * CONTENT
 * --------------------------------------------------------- */

enum class ContentType {
    MCQ,
    NOTES,
    PDF
}

data class ContentItem(
    val id: String,
    val type: ContentType,
    val title: String,
    val subjectId: String,
    val chapterId: String,
    val resourceUrl: String? = null
)

/* ---------------------------------------------------------
 * PREVIOUS YEAR PAPERS
 * --------------------------------------------------------- */

data class PreviousYearPaper(
    val id: String,
    val title: String,
    val boardId: String,
    val classId: String,
    val subjectId: String,
    val year: Int,
    val pdfUrl: String? = null
)

/* ---------------------------------------------------------
 * SAMPLE PAPERS
 * --------------------------------------------------------- */

data class SamplePaper(
    val id: String,
    val title: String,
    val boardId: String,
    val classId: String,
    val subjectId: String,
    val pdfUrl: String? = null
)

/* ---------------------------------------------------------
 * TEST SERIES
 * --------------------------------------------------------- */

data class TestSeries(
    val id: String,
    val title: String,
    val boardId: String,
    val classId: String,
    val subjectId: String? = null,
    val description: String = "",
    val totalTests: Int = 0
)

/* ---------------------------------------------------------
 * STABLE CURRICULUM IDS
 * --------------------------------------------------------- */

object CurriculumContentIds {

    const val MP_BOARD = "mp_board"
    const val CBSE = "cbse"

    const val CLASS_11 = "class_11"
    const val CLASS_12 = "class_12"

    const val ACCOUNTANCY = "accountancy"
    const val BUSINESS_STUDIES = "business_studies"
    const val MATHEMATICS = "mathematics"
    const val ENGLISH = "english"
    const val HINDI = "hindi"

    /* MP Board Economics */

    const val MP_BOARD_CLASS_12_ECONOMICS_MICRO =
        "mp_board_class_12_economics_micro"

    const val MP_BOARD_CLASS_12_ECONOMICS_MACRO =
        "mp_board_class_12_economics_macro"

    /* CBSE Economics */

    const val CBSE_CLASS_12_ECONOMICS_INDIAN =
        "cbse_class_12_economics_indian"

    const val CBSE_CLASS_12_ECONOMICS_MACRO =
        "cbse_class_12_economics_macro"
}
