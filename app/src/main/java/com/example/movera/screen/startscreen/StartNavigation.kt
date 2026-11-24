package com.example.movera.screen.startscreen
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movera.navigation.Route

fun NavGraphBuilder.startNavigation(navController: NavController) {
    composable(route = Route.StartRoute.route) {
        val viewModel: StartViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()


        LaunchedEffect(Unit) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    is StartEvent.NavigateToSplash -> {
                        navController.navigate(Route.SplashRoute.route) {

                        }
                    }

                    else -> {}
                }
            }
        }


        StartScreen(
            state = state,
            event = viewModel::onEvent,
            onNavigateToSplash = {
                navController.navigate(Route.SplashRoute.route)
            }
        )
    }
}