package com.example.movera.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.movera.screen.createscreen.createNavigation
import com.example.movera.screen.fillprofilescreen.fillprofileNavigation
import com.example.movera.screen.forgotscreen.forgotNavigation
import com.example.movera.screen.letscreen.letNavigation
import com.example.movera.screen.loginscreen.loginNavigation
import com.example.movera.screen.signscreen.signNavigation
import com.example.movera.screen.splashscreen.splashNavigation
import com.example.movera.screen.startscreen.startNavigation

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    Scaffold() { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.StartRoute.route,
            modifier = Modifier.padding(contentPadding)
        ) {
            startNavigation(navController)
            splashNavigation(navController)
            forgotNavigation(navController)
            letNavigation(navController)
            createNavigation(navController)

            //newpasswordNavigation(navController)

            fillprofileNavigation(navController)

             signNavigation(navController)

             loginNavigation(navController)
           // registerNavigation(navController)
            //homeNavigation(navController)
        }
    }
}