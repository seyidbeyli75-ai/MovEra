package com.example.movera.screen.fillprofilescreen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movera.navigation.Route


fun NavGraphBuilder.fillprofileNavigation(navController: NavController) {
    composable(route = Route.FillingProfileRoute.route) {
        val viewModel: FillProfileViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()


        LaunchedEffect(true) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    FillProfileEffect.NavigateToHome ->
                        navController.navigate(Route.HomeRoute.route) {
                            popUpTo(Route.LetRoute.route) { inclusive = true }
                        }

                    FillProfileEffect.NavigateToCreate ->
                        navController.navigate(Route.CreateRoute.route)

                    FillProfileEffect.NavigateToForgot ->
                        navController.navigate(Route.ForgotRoute.route)



                    else -> {}
                }
            }
        }


        FillProfileScreen(
            state = state,
            event = viewModel::onEvent
        )
    }
}