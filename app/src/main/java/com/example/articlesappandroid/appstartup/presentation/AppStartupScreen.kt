package com.example.articlesappandroid.appstartup.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.articlesappandroid.ArticlesApp
import com.example.articlesappandroid.appstartup.application.AppStartupViewModel
import com.example.articlesappandroid.appstartup.application.AppStartupState
import com.example.articlesappandroid.auth.application.AuthViewModel
import com.example.articlesappandroid.common.helpers.viewModelFactory
import com.example.articlesappandroid.navigation.AppStartupRoute
import com.example.articlesappandroid.navigation.AuthRoute
import com.example.articlesappandroid.navigation.DashboardRoute


@Composable
fun AppStartupScreen(navController: NavController) {
    val viewModel = viewModel<AppStartupViewModel>(
        factory = viewModelFactory {
            AppStartupViewModel(ArticlesApp.di.localStorageRepository)
        }
    )
    val state by viewModel.state.collectAsStateWithLifecycle()
    var previousState by remember { mutableStateOf<AppStartupState?>(null) }
    if (state != previousState) {
        previousState = state
        when (state) {
            AppStartupState.AUTHORIZED -> {
                navController.navigate(DashboardRoute) {
                    popUpTo(AppStartupRoute) {
                        inclusive = true
                    }
                }
            }

            AppStartupState.UNAUTHORIZED -> {
                navController.navigate(AuthRoute) {
                    popUpTo(AppStartupRoute) {
                        inclusive = true
                    }
                }
            }

            else -> {
                //Do nothing
            }
        }
    }
}
