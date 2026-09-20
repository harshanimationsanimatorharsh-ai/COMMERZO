package com.commerzo.app.data.repository.content

/**
 * Contract for communicating with the COMMERZO backend.
 *
 * This interface intentionally contains no HTTP-library code.
 * The actual implementation can later use Retrofit, Ktor,
 * OkHttp, or another networking solution.
 *
 * Keeping networking behind this contract prevents the rest
 * of the application from depending directly on a networking
 * library.
 */
interface RemoteContentClient {

    suspend fun getSubjects(
        request: RemoteContentRequest
    ): RemoteContentResult<List<com.commerzo.app.data.model.content.ContentSubject>>

    suspend fun getChapters(
        request: RemoteContentRequest
    ): RemoteContentResult<List<com.commerzo.app.data.model.content.ContentChapter>>

    suspend fun getContent(
        request: RemoteContentRequest
    ): RemoteContentResult<List<com.commerzo.app.data.model.content.ContentItem>>

    suspend fun getPreviousYearPapers(
        request: RemoteContentRequest
    ): RemoteContentResult<List<com.commerzo.app.data.model.content.PreviousYearPaper>>

    suspend fun getSamplePapers(
        request: RemoteContentRequest
    ): RemoteContentResult<List<com.commerzo.app.data.model.content.SamplePaper>>

    suspend fun getTestSeries(
        request: RemoteContentRequest
    ): RemoteContentResult<List<com.commerzo.app.data.model.content.TestSeries>>

    suspend fun getModules(
        request: RemoteContentRequest
    ): RemoteContentResult<List<com.commerzo.app.data.model.content.ContentModule>>
}
