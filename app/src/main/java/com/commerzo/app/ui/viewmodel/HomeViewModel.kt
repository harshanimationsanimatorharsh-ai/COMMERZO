package com.commerzo.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.SubjectData
import com.commerzo.app.data.repository.SubjectRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    private val repository = SubjectRepository()

    private val _subjects = MutableStateFlow(
        repository.getSubjects(
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12
        )
    )

    val subjects: StateFlow<List<SubjectData>> =
        _subjects.asStateFlow()

    fun changeSelection(
        board: Board,
        classLevel: ClassLevel
    ) {
        _subjects.value = repository.getSubjects(
            board = board,
            classLevel = classLevel
        )
    }
}
