package com.commerzo.app.data.repository.content

/**
 * Defines the backend endpoints required by COMMERZO's
 * dynamic content system.
 *
 * No networking library is used yet.
 *
 * These paths will later be connected to the actual
 * backend/API implementation.
 */
object RemoteContentEndpoint {

    const val SUBJECTS = "content/subjects"

    const val CHAPTERS = "content/chapters"

    const val CONTENT = "content/items"

    const val PREVIOUS_YEAR_PAPERS =
        "content/previous-year-papers"

    const val SAMPLE_PAPERS =
        "content/sample-papers"

    const val TEST_SERIES =
        "content/test-series"

    const val MODULES =
        "content/modules"
}
