package com.example.movera.navigation

sealed class Route(val  route: String) {
    data object StartRoute : Route("startRoute")
    data object SplashRoute : Route("splashRoute")
    data object LetRoute : Route("letRoute")

    data object LoginRoute : Route("loginRoute")
    data object SignRoute : Route("signRoute")

    data object HomeRoute: Route("homeRoute")
    data object CreateRoute: Route("createRoute")


    data object ForgotRoute: Route("forgotRoute")
    data object FillingProfileRoute: Route("fillingProfileRoute")




}