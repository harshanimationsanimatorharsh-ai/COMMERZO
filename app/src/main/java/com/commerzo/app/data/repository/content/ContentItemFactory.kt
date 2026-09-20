package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentType

/**
 * Factory for creating learning-content items.
 *
 * Supported learning content:
 * - MCQs
 * - Notes
 * - PDFs
 *
 * resourceUrl is optional because local content can exist
 * without a remote URL. Later, backend/CMS content can
 * provide URLs without changing this model.
 */
object ContentItemFactory {

    fun createMcq(
        id: String,
        title: String,
        subjectId: String,
        chapterId: String,
        resourceUrl: String? = null
    ): ContentItem {

        return ContentItem(
            id = id,
            type = ContentType.MCQ,
            title = title,
            subjectId = subjectId,
            chapterId = chapterId,
            resourceUrl = resourceUrl
        )
    }

    fun createNotes(
        id: String,
        title: String,
        subjectId: String,
        chapterId: String,
        resourceUrl: String? = null
    ): ContentItem {

        return ContentItem(
            id = id,
            type = ContentType.NOTES,
            title = title,
            subjectId = subjectId,
            chapterId = chapterId,
            resourceUrl = resourceUrl
        )
    }

    fun createPdf(
        id: String,
        title: String,
        subjectId: String,
        chapterId: String,
        resourceUrl: String? = null
    ): ContentItem {

        return ContentItem(
            id = id,
            type = ContentType.PDF,
            title = title,
            subjectId = subjectId,
            chapterId = chapterId,
            resourceUrl = resourceUrl
        )
    }
}
