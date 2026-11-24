package com.example.movera.screen.fillprofilescreen

import androidx.lifecycle.viewModelScope
import com.example.movera.common.BaseViewModel
import com.example.movera.data.AuthRepository
import com.example.movera.data.toAuthMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FillProfileViewModel @Inject constructor(
) : BaseViewModel<FillProfileUiState, FillProfileEvent>(FillProfileUiState()) {
    private val _effect = MutableSharedFlow<FillProfileEffect>()
    val effect: SharedFlow<FillProfileEffect> get() = _effect//shared flowun state flowdan ferqi odurki yaddasda hec bir sey saxlamir sadece ona tiklyanada ise dusur.


    override fun onEvent(event: FillProfileEvent) {
        when (event) {
            is FillProfileEvent.OnChangeEmail -> {
                updateState {
                    it.copy(
                        email = event.email,
                        errorMessage = null
                    )
                }
            }

            is FillProfileEvent.OnChangeNumber -> {
                updateState {
                    it.copy(
                        number = event.number,
                        errorMessage = null
                    )
                }
            }

            is FillProfileEvent.OnChangeFullName -> {
                updateState {
                    it.copy(
                        full_name = event.full_name,
                        errorMessage = null
                    )
                }
            }

            is FillProfileEvent.OnChangeNickName -> {
                updateState {
                    it.copy(
                        nickname = event.nickname,
                        errorMessage = null
                    )
                }
            }

            is FillProfileEvent.OnChangeGender -> {
                updateState {
                    it.copy(
                        gender = event.gender,
                        errorMessage = null
                    )
                }
            }

            is FillProfileEvent.CreateClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(FillProfileEffect.NavigateToCreate)
                }
            }

            is FillProfileEvent.ForgotClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(FillProfileEffect.NavigateToForgot)
                }
            }
            is FillProfileEvent.HomeClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(FillProfileEffect.NavigateToHome)
                }
            }






            else -> {}
        }
    }
}


data class FillProfileUiState(
    val email: String = "",
    val gender: String = "",
    val full_name: String = "",
    val nickname: String = "",
    val number: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isPasswordError: Boolean = false
)

sealed interface FillProfileEvent {
    data class OnChangeEmail(val email: String) : FillProfileEvent
    data class OnChangeGender(val gender: String) : FillProfileEvent

    data class OnChangeFullName(val full_name: String) : FillProfileEvent
    data class OnChangeNickName(val nickname: String) : FillProfileEvent

    data class OnChangeNumber(val number: String) : FillProfileEvent

    object HomeClick : FillProfileEvent
    object CreateClick : FillProfileEvent
    object ForgotClick : FillProfileEvent





}

sealed interface FillProfileEffect {
    data object NavigateToForgot : FillProfileEffect
    data object NavigateToCreate : FillProfileEffect

    data object NavigateToHome : FillProfileEffect
}