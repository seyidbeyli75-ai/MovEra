package com.example.movera.screen.loginscreen

import androidx.lifecycle.viewModelScope
import com.example.movera.common.BaseViewModel
import com.example.movera.data.AuthRepository
import com.example.movera.data.toAuthMessage
import com.example.movera.screen.letscreen.LetEffect
import com.example.movera.screen.letscreen.LetEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : BaseViewModel<LoginUiState, LoginEvent>(LoginUiState()) {
    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect: SharedFlow<LoginEffect> get() = _effect//shared flowun state flowdan ferqi odurki yaddasda hec bir sey saxlamir sadece ona tiklyanada ise dusur.


    override fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnChangeEmail -> {
                updateState {
                    it.copy(
                        email = event.email,
                        errorMessage = null
                    )
                }
            }

            is LoginEvent.OnChangePassword -> {
                updateState {
                    it.copy(
                        password = event.password,
                        errorMessage = null
                    )
                }
            }

            is LoginEvent.SignClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(LoginEffect.NavigateToSign)
                }
            }

            is LoginEvent.LetClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(LoginEffect.NavigateToLet)
                }
            }
            is LoginEvent.ForgotClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(LoginEffect.NavigateToForgot)
                }
            }

            is LoginEvent.SignInClick -> {
                val currentState = uiState.value

                if (currentState.email.isBlank() || currentState.password.isBlank()) {
                    updateState { it.copy(errorMessage = "Bütün sahələri doldurun") }
                } else {
                    viewModelScope.launch {
                        updateState { it.copy(isLoading = true, errorMessage = null) }

                        val result = authRepository.signIn(currentState.email.trim(), currentState.password)

                        if (result.isSuccess) {
                            updateState { it.copy(isLoading = false) }
                            _effect.emit(LoginEffect.NavigateToHome)
                        } else {
                            val message = result.exceptionOrNull()?.toAuthMessage() ?: "Xəta baş verdi"
                            updateState { it.copy(isLoading = false, errorMessage = message) }
                        }
                    }
                }
            }


            is LoginEvent.OnRememberMeChange ->
                updateState {
                    it.copy(rememberMe = event.checked) }

            else -> {}
        }
    }
}


data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isPasswordError: Boolean = false,
    val rememberMe: Boolean = false
)

sealed interface LoginEvent {
    data class OnChangeEmail(val email: String) : LoginEvent

    data class OnChangePassword(val password: String) : LoginEvent
    object SignClick : LoginEvent
    data class OnRememberMeChange(val checked: Boolean) : LoginEvent

    object ForgotClick : LoginEvent
    object LetClick : LoginEvent

    data object SignInClick : LoginEvent


}

sealed interface LoginEffect {
    data object NavigateToForgot : LoginEffect

    data object NavigateToLet : LoginEffect
    data object NavigateToHome : LoginEffect
    data object NavigateToSign : LoginEffect
}
