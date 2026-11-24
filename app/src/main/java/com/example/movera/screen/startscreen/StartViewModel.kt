package com.example.movera.screen.startscreen


import androidx.lifecycle.viewModelScope
import com.example.movera.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class StartViewModel @Inject constructor(

) : BaseViewModel<StartUiState, StartEvent>(StartUiState()) {


    private val _effect = MutableSharedFlow<StartEvent>()
    val effect: SharedFlow<StartEvent> get() = _effect
  override  fun onEvent(event: StartEvent) {
     when (event) {


            is StartEvent.StartClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                   _effect.emit(StartEvent.NavigateToSplash)
                }
            }

         else -> {}
        }
    }
}



data class StartUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

sealed interface StartEvent {
    object StartClick : StartEvent
    object NavigateToSplash : StartEvent



}



