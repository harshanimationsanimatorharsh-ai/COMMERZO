package com.commerzo.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.SubjectData
import com.commerzo.app.data.repository.SubjectRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SubjectSelectionViewModel : ViewModel() {

    private val repository = SubjectRepository()

    private val _board =
        MutableStateFlow(Board.MP_BOARD)

    val board: StateFlow<Board> =
        _board.asStateFlow()

    private val _classLevel =
        MutableStateFlow(ClassLevel.CLASS_12)

    val classLevel: StateFlow<ClassLevel> =
        _classLevel.asStateFlow()

    private val _subjects =
        MutableStateFlow(
            repository.getSubjects(
                Board.MP_BOARD,
                ClassLevel.CLASS_12
            )
        )

    val subjects: StateFlow<List<SubjectData>> =
        _subjects.asStateFlow()

    fun setBoard(newBoard: Board) {

        _board.value = newBoard

        refreshSubjects()
    }

    fun setClassLevel(newClass: ClassLevel) {

        _classLevel.value = newClass

        refreshSubjects()
    }

    private fun refreshSubjects() {

        _subjects.value = repository.getSubjects(
            board = _board.value,
            classLevel = _classLevel.value
        )
    }
}
