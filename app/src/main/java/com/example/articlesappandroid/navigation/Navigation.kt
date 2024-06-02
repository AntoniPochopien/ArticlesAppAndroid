package com.example.articlesappandroid.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.articlesappandroid.appstartup.presentation.AppStartupScreen
import com.example.articlesappandroid.auth.presentation.AuthScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppStartupScreenRoute){
        composable<AppStartupScreenRoute>{
            AppStartupScreen(navController)
        }
        composable<AuthScreenRoute>{
            AuthScreen()
        }
    }
}