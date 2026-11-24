package com.example.movera.screen.forgotscreen
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movera.navigation.Route


fun NavGraphBuilder.forgotNavigation(navController: NavController) {
    composable(route = Route.ForgotRoute.route) {
        val viewModel: ForgotViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()


        LaunchedEffect(true) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    ForgotEffect.NavigateToFillingProfile ->
                        navController.navigate(Route.FillingProfileRoute.route) {
                            popUpTo(Route.LetRoute.route) { inclusive = true }
                        }

                    ForgotEffect.NavigateToSign ->
                        navController.navigate(Route.SignRoute.route)



                    else -> {}
                }
            }
        }


        ForgotScreen(
            state = state,
            event = viewModel::onEvent
        )
    }
}
