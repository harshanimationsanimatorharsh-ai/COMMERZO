package com.commerzo.app.data.repository.content

import com.commerzo.app.data.model.content.ContentModule

/**
 * Central registry for COMMERZO content modules.
 *
 * The registry currently uses the local module factory.
 * Later, these modules can be loaded from a backend/CMS
 * without changing the UI architecture.
 */
object ContentModuleRegistry {

    fun getModules(
        boardId: String,
        classId: String
    ): List<ContentModule> {

        return ContentModuleFactory.createModules(
            boardId = boardId,
            classId = classId
        )
    }

    fun getModule(
        boardId: String,
        classId: String,
        moduleId: String
    ): ContentModule? {

        return getModules(
            boardId = boardId,
            classId = classId
        ).firstOrNull { module ->
            module.id == moduleId
        }
    }
}
