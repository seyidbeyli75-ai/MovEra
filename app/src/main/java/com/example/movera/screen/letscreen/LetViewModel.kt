package com.example.movera.screen.letscreen

import androidx.lifecycle.viewModelScope
import com.example.movera.common.BaseViewModel
import com.example.movera.screen.startscreen.StartEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LetViewModel @Inject constructor(

) : BaseViewModel<LetUiState, LetEvent>(LetUiState()) {


    private val _effect = MutableSharedFlow<LetEffect>()
    val effect: SharedFlow<LetEffect> get() = _effect
    override  fun onEvent(event: LetEvent) {
        when (event) {


            is LetEvent.LoginClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(LetEffect.NavigateToLogin)
                }
            }
            is LetEvent.BackClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(LetEffect.NavigateToStart)
                }
            }

            is LetEvent.SignClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(LetEffect.NavigateToSign)
                }
            }

            else -> {}
        }
    }
}



data class LetUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

sealed interface LetEvent {
    data object LoginClick : LetEvent
    data object BackClick : LetEvent
    data object SignClick : LetEvent



}
sealed interface LetEffect {
    data object NavigateToLogin : LetEffect
    data object NavigateToSign : LetEffect

    data object NavigateToStart : LetEffect
}