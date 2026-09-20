package com.commerzo.app.data.repository.content

/**
 * Provides the single ContentDataSource instance used
 * by the COMMERZO content layer.
 */
object ContentDataSourceProvider {

    private val dataSource: ContentDataSource by lazy {
        ContentDataSource()
    }

    fun getDataSource(): ContentDataSource {
        return dataSource
    }
}
