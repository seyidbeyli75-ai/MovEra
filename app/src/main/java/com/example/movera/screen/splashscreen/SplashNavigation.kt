package com.example.movera.screen.splashscreen

import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movera.navigation.Route
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

fun NavGraphBuilder.splashNavigation(navController: NavController){
    composable(route = Route.SplashRoute.route) {

        val viewModel: SplashViewModel = hiltViewModel()

        LaunchedEffect(Unit) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    SplashEffect.NavigateToHome ->
                        navController.navigate(Route.HomeRoute.route) {
                            popUpTo(Route.SplashRoute.route) { inclusive = true }
                        }
                    SplashEffect.NavigateToLet ->
                        navController.navigate(Route.LetRoute.route) {
                            popUpTo(Route.SplashRoute.route) { inclusive = true }
                        }

                    else -> {}
                }
            }
        }

        SplashScreen()
    }
}