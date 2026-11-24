package com.example.movera.screen.signscreen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movera.navigation.Route
import com.example.movera.screen.loginscreen.LoginEffect
import com.example.movera.screen.loginscreen.LoginScreen
import com.example.movera.screen.loginscreen.LoginViewModel

fun NavGraphBuilder.signNavigation(navController: NavController) {
    composable(route = Route.SignRoute.route) {
        val viewModel: SignViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()


        LaunchedEffect(true) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    SignEffect.NavigateToFillProfile ->
                        navController.navigate(Route.FillingProfileRoute.route) {
                            popUpTo(Route.FillingProfileRoute.route) { inclusive = true }
                        }

                    SignEffect.NavigateToLogin ->
                        navController.navigate(Route.LoginRoute.route)



                    else -> {}
                }
            }
        }


        SignScreen (
            state = state,
            event = viewModel::onEvent
        )
    }
}
