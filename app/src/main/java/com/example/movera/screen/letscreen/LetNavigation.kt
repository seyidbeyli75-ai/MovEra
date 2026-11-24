package com.example.movera.screen.letscreen

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movera.navigation.Route

fun NavGraphBuilder.letNavigation(navController: NavController) {
    composable(route = Route.LetRoute.route) {
        val viewModel: LetViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()


        LaunchedEffect(true) {
            viewModel.effect.collect { effect ->
                when (effect) {
                     LetEffect.NavigateToLogin -> {
                        navController.navigate(Route.LoginRoute.route) {

                        }
                    }
                     LetEffect.NavigateToStart -> {
                        navController.popBackStack(Route.StartRoute.route, inclusive = false)
                    }
                    LetEffect.NavigateToSign -> {
                        navController.navigate(Route.SignRoute.route) {
                        }
                    }

                    else -> {}
                }
            }
        }


        LetScreen(

            event = viewModel::onEvent

        )
    }
}