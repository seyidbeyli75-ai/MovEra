package com.example.movera.screen.splashscreen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movera.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _effect = MutableSharedFlow<SplashEffect>()
    val effect: SharedFlow<SplashEffect> = _effect.asSharedFlow()

    init {
        viewModelScope.launch {
            delay(2000)
            if (authRepository.isLoggedIn) {
                _effect.emit(SplashEffect.NavigateToHome)
            } else {
                _effect.emit(SplashEffect.NavigateToLet)
            }
        }
    }
}

sealed interface SplashEffect {
    data object NavigateToHome : SplashEffect
    data object NavigateToLet : SplashEffect


    data object NavigateToStart : SplashEffect
}