package com.visionfit.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.visionfit.app.presentation.ui.screens.SplashScreen

/**
 * RootNavigation - Composable raiz para navegação da aplicação
 *
 * Define a estrutura de navegação principal e todas as rotas.
 *
 * @author VisionFit Team
 */
@Composable
fun RootNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        // Splash Screen
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        // TODO: Adicionar mais rotas conforme desenvolvidas
    }
}