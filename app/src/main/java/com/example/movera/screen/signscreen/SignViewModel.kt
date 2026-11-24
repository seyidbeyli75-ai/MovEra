package com.example.movera.screen.signscreen

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
class SignViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : BaseViewModel<SignUiState, SignEvent>(SignUiState()) {
    private val _effect = MutableSharedFlow<SignEffect>()
    val effect: SharedFlow<SignEffect> get() = _effect//shared flowun state flowdan ferqi odurki yaddasda hec bir sey saxlamir sadece ona tiklyanada ise dusur.


    override fun onEvent(event: SignEvent) {
        when (event) {
            is SignEvent.OnChangeEmail -> {
                updateState {
                    it.copy(
                        email = event.email,
                        errorMessage = null
                    )
                }
            }

            is SignEvent.OnChangePassword -> {
                updateState {
                    it.copy(
                        password = event.password,
                        errorMessage = null
                    )
                }
            }

            is SignEvent.SignUpClick -> {
                val currentState = uiState.value
                val email = currentState.email.trim()

                when {
                    email.isBlank() || currentState.password.isBlank() ->
                        updateState { it.copy(errorMessage = "Bütün sahələri doldurun") }



                    currentState.password.length < 6 ->
                        updateState { it.copy(errorMessage = "Şifrə ən azı 6 simvol olmalıdır") }

                    else -> viewModelScope.launch {
                        updateState { it.copy(isLoading = true, errorMessage = null) }

                        val result = authRepository.signUp(email, currentState.password)

                        if (result.isSuccess) {
                            updateState { it.copy(isLoading = false) }
                            _effect.emit(SignEffect.NavigateToFillProfile)
                        } else {
                            val message = result.exceptionOrNull()?.toAuthMessage() ?: "Xəta baş verdi"
                            updateState { it.copy(isLoading = false, errorMessage = message) }
                        }
                    }
                }
            }



            is SignEvent.LoginClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(SignEffect.NavigateToLogin)
                }
            }




            is SignEvent.OnRememberMeChange ->
                updateState {
                    it.copy(rememberMe = event.checked) }

            else -> {}
        }
    }
}


data class SignUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isPasswordError: Boolean = false,
    val rememberMe: Boolean = false
)

sealed interface SignEvent {
    data class OnChangeEmail(val email: String) : SignEvent

    data class OnChangePassword(val password: String) : SignEvent
    object LoginClick: SignEvent
    data class OnRememberMeChange(val checked: Boolean) : SignEvent

    object SignUpClick: SignEvent



}

sealed interface SignEffect {
    data object NavigateToFillProfile : SignEffect

    data object NavigateToLogin : SignEffect

}
