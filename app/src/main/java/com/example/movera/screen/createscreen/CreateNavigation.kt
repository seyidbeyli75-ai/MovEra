package com.example.movera.screen.createscreen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movera.navigation.Route
import com.example.movera.screen.fillprofilescreen.FillProfileEffect
import com.example.movera.screen.fillprofilescreen.FillProfileScreen
import com.example.movera.screen.fillprofilescreen.FillProfileViewModel

fun NavGraphBuilder.createNavigation(navController: NavController) {
    composable(route = Route.CreateRoute.route) {
        val viewModel: CreateViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()


        LaunchedEffect(true) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    CreateEffect.NavigateToHome ->
                        navController.navigate(Route.HomeRoute.route) {
                            popUpTo(Route.LetRoute.route) { inclusive = true }
                        }

                    CreateEffect.NavigateToFillingProfile ->
                        navController.navigate(Route.FillingProfileRoute.route)





                    else -> {}
                }
            }
        }


        CreateScreen(
            state = state,
            event = viewModel::onEvent
        )
    }
}