package com.visionfit.app.presentation.navigation

/**
 * Screen - Definição de todas as telas da aplicação
 *
 * Define rotas para navegação e argumentos necessários.
 *
 * @author VisionFit Team
 */
sealed class Screen(val route: String) {
    // Telas de autenticação
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Register : Screen("register")

    // Telas principais
    object Home : Screen("home")
    object ChooseGym : Screen("choose_gym")
    object ChooseEquipment : Screen("choose_equipment/{gymId}") {
        fun createRoute(gymId: String) = "choose_equipment/$gymId"
    }
    object Map : Screen("map/{gymId}") {
        fun createRoute(gymId: String) = "map/$gymId"
    }
    object Navigation : Screen("navigation/{gymId}/{equipmentId}") {
        fun createRoute(gymId: String, equipmentId: String) = "navigation/$gymId/$equipmentId"
    }
    object History : Screen("history")
    object Profile : Screen("profile")
    object Settings : Screen("settings")
    object Admin : Screen("admin/{gymId}") {
        fun createRoute(gymId: String) = "admin/$gymId"
    }
    object SOS : Screen("sos")
}