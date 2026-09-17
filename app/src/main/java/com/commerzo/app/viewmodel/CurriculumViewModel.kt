package com.commerzo.app.viewmodel

import androidx.lifecycle.ViewModel
import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.CurriculumSelection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CurriculumViewModel : ViewModel() {

    private val _selection = MutableStateFlow(CurriculumSelection())
    val selection: StateFlow<CurriculumSelection> = _selection.asStateFlow()

    fun setBoard(board: Board) {
        _selection.value = _selection.value.copy(board = board)
    }

    fun setClassLevel(classLevel: ClassLevel) {
        _selection.value = _selection.value.copy(classLevel = classLevel)
    }

    fun setSelection(
        board: Board,
        classLevel: ClassLevel
    ) {
        _selection.value = CurriculumSelection(
            board = board,
            classLevel = classLevel
        )
    }
}
