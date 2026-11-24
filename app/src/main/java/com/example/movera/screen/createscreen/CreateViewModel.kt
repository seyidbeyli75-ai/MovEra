package com.example.movera.screen.createscreen

import androidx.lifecycle.viewModelScope
import com.example.movera.common.BaseViewModel
import com.example.movera.screen.signscreen.SignEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(
) : BaseViewModel<CreateUiState, CreateEvent>(CreateUiState()) {
    private val _effect = MutableSharedFlow<CreateEffect>()
    val effect: SharedFlow<CreateEffect> get() = _effect//shared flowun state flowdan ferqi odurki yaddasda hec bir sey saxlamir sadece ona tiklyanada ise dusur.


    override fun onEvent(event: CreateEvent) {
        when (event) {
            is CreateEvent.OnChangeSuperPassword -> {
                updateState {
                    it.copy(
                        superPassword = event.superPassword,
                        errorMessage = null
                    )
                }
            }
            is CreateEvent.OnChangeSecretPassword -> {
                updateState {
                    it.copy(
                        secretPassword = event.secretPassword,
                        errorMessage = null
                    )
                }
            }



            is CreateEvent.HomeClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(CreateEffect.NavigateToHome)
                }
            }

            is CreateEvent.FillingProfileClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(CreateEffect.NavigateToFillingProfile)
                }
            }
            is CreateEvent.OnRememberMeChange ->
                updateState {
                    it.copy(rememberMe = event.checked) }







            else -> {}
        }
    }
}


data class CreateUiState(
    val superPassword: String = "",
    val secretPassword: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isPasswordError: Boolean = false,
    val rememberMe: Boolean = false

)

sealed interface CreateEvent {
    data class OnChangeSuperPassword(val superPassword: String) : CreateEvent

    data class OnChangeSecretPassword(val secretPassword: String) : CreateEvent

    object HomeClick : CreateEvent
    object FillingProfileClick : CreateEvent
    data class OnRememberMeChange(val checked: Boolean) : CreateEvent






}

sealed interface CreateEffect {
    data object NavigateToFillingProfile : CreateEffect

    data object NavigateToHome : CreateEffect
}