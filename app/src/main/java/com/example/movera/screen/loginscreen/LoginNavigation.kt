package com.example.movera.screen.loginscreen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movera.navigation.Route


fun NavGraphBuilder.loginNavigation(navController: NavController) {
    composable(route = Route.LoginRoute.route) {
        val viewModel: LoginViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()


        LaunchedEffect(true) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    LoginEffect.NavigateToHome ->
                        navController.navigate(Route.HomeRoute.route) {
                            popUpTo(Route.LetRoute.route) { inclusive = true }
                        }

                    LoginEffect.NavigateToSign ->
                        navController.navigate(Route.SignRoute.route)

                    LoginEffect.NavigateToForgot ->
                        navController.navigate(Route.ForgotRoute.route)

                    LoginEffect.NavigateToLet ->
                        navController.popBackStack()

                    else -> {}
                }
            }
        }


        LoginScreen(
            state = state,
            event = viewModel::onEvent
        )
    }
}
