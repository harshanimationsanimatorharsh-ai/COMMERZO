package com.commerzo.app.data.model.content

/**
 * Top-level content modules available in COMMERZO.
 *
 * These modules are intentionally separate so that
 * content can later be managed independently through
 * a backend/CMS without requiring an APK update.
 */
enum class ContentModuleType {

    /**
     * Regular curriculum content:
     * MCQs, Notes and PDFs.
     */
    LEARNING_CONTENT,

    /**
     * Previous year question papers.
     */
    PREVIOUS_YEAR_PAPERS,

    /**
     * Sample/model papers.
     */
    SAMPLE_PAPERS,

    /**
     * Test series.
     */
    TEST_SERIES
}

/**
 * Identifies a COMMERZO content module.
 *
 * subjectId is nullable because some future
 * test-series or paper collections may cover
 * multiple subjects.
 */
data class ContentModule(
    val id: String,
    val type: ContentModuleType,
    val title: String,
    val boardId: String,
    val classId: String,
    val subjectId: String? = null,
    val description: String = "",
    val isEnabled: Boolean = true
)
