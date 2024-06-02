package com.example.articlesappandroid.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.articlesappandroid.appstartup.presentation.AppStartupScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppStartupRoute){
        composable<AppStartupRoute>{
            AppStartupScreen(navController)
        }
    }
}