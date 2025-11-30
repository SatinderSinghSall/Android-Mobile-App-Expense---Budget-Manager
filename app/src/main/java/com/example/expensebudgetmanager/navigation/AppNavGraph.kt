package com.example.expensebudgetmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensebudgetmanager.ui.screens.*

@Composable
fun AppNavGraph(startDestination: String = "welcome") {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable("splash") { SplashScreen(navController) }
        composable("welcome") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("signup") { SignUpScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
    }
}
