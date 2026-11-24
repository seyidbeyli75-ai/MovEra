package com.example.movera.screen.forgotscreen

import androidx.lifecycle.viewModelScope
import com.example.movera.common.BaseViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotViewModel @Inject constructor(

) : BaseViewModel<ForgotUiState, ForgotEvent>(ForgotUiState()) {
    private val _effect = MutableSharedFlow<ForgotEffect>()
    val effect: SharedFlow<ForgotEffect> get() = _effect//shared flowun state flowdan ferqi odurki yaddasda hec bir sey saxlamir sadece ona tiklyanada ise dusur.


    override fun onEvent(event: ForgotEvent) {
        when (event) {


            is ForgotEvent.OnEnterNumber1 -> {
                updateState {
                    it.copy(
                        number1 = event.number1,
                        errorMessage = null
                    )
                }
            }
            is ForgotEvent.OnEnterNumber2 -> {
                updateState {
                    it.copy(
                        number2 = event.number2,
                        errorMessage = null
                    )
                }
            } is ForgotEvent.OnEnterNumber3 -> {
            updateState {
                it.copy(
                    number3 = event.number3,
                    errorMessage = null
                )
            }
        } is ForgotEvent.OnEnterNumber4 -> {
            updateState {
                it.copy(
                    number4 = event.number4,
                    errorMessage = null
                )
            }
        }

            is ForgotEvent.SignClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(ForgotEffect.NavigateToSign)
                }
            }

            is ForgotEvent.FillingProfileClick -> {
                val currentState = uiState.value
                updateState { it.copy(errorMessage = null) }
                viewModelScope.launch {
                    _effect.emit(ForgotEffect.NavigateToFillingProfile)
                }
            }


            else -> {}
        }
    }
}


data class ForgotUiState(
    val number1: String = "",
    val number2: String = "",
    val number3: String = "",
    val number4: String = "",

    val isLoading: Boolean = false,
    val errorMessage: String? = null)

sealed interface ForgotEvent {

    data class OnEnterNumber1(val number1: String) : ForgotEvent
    data class OnEnterNumber2(val number2: String) : ForgotEvent
    data class OnEnterNumber3(val number3: String) : ForgotEvent
    data class OnEnterNumber4(val number4: String) : ForgotEvent




    object SignClick : ForgotEvent
   object FillingProfileClick : ForgotEvent


}

sealed interface ForgotEffect {

    data object NavigateToFillingProfile : ForgotEffect

    data object NavigateToSign : ForgotEffect
}