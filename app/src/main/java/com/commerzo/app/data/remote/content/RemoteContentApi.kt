package com.commerzo.app.data.remote.content

import com.commerzo.app.data.model.content.ContentChapter
import com.commerzo.app.data.model.content.ContentItem
import com.commerzo.app.data.model.content.ContentSubject
import com.commerzo.app.data.model.content.ContentModule
import com.commerzo.app.data.model.content.PreviousYearPaper
import com.commerzo.app.data.model.content.SamplePaper
import com.commerzo.app.data.model.content.TestSeries

/**

* Remote API contract for COMMERZO dynamic content.

* 

* This interface describes the backend endpoints that will eventually

* provide curriculum content without requiring an APK update.

* 

* Actual networking implementation will be connected later.
  */
  interface RemoteContentApi {
  
  suspend fun getSubjects(
  boardId: String,
  classId: String
  ): List<ContentSubject>
  
  suspend fun getChapters(
  boardId: String,
  classId: String,
  subjectId: String
  ): List<ContentChapter>
  
  suspend fun getContent(
  boardId: String,
  classId: String,
  subjectId: String,
  chapterId: String
  ): List<ContentItem>
  
  suspend fun getPreviousYearPapers(
  boardId: String,
  classId: String,
  subjectId: String? = null
  ): List<PreviousYearPaper>
  
  suspend fun getSamplePapers(
  boardId: String,
  classId: String,
  subjectId: String? = null
  ): List<SamplePaper>
  
  suspend fun getTestSeries(
  boardId: String,
  classId: String,
  subjectId: String? = null
  ): List<TestSeries>
  
  suspend fun getModules(
  boardId: String,
  classId: String
  ): List<ContentModule>
  }
