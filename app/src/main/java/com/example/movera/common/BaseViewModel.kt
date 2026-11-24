package com.example.movera.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class  BaseViewModel<State,Event> (
    protected val initialState:State
): ViewModel() {


    private val _uiState = MutableStateFlow<State>(initialState)
    val uiState : StateFlow<State> get() = _uiState.asStateFlow()

    abstract fun onEvent(event: Event)

    protected fun updateState(stateUpdate: (State) -> State){
        _uiState.update(stateUpdate)
    }

    protected fun getCurrentState():State = _uiState.value
}