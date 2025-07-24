package com.example.modelviewviewmodel.StateFlow

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LiftViewModel : ViewModel() {

    private val _floor = MutableStateFlow(0)
    val floor: StateFlow<Int> =_floor

    fun updateFloor(newFloor: Int) {
        _floor.value = newFloor
    }
    fun resetFloor(groundFloor: Int) {
        _floor.value = groundFloor
    }
    fun previousFloor(prevFloor: Int) {
if (prevFloor >= -4){
    _floor.value = prevFloor
}
    }
}