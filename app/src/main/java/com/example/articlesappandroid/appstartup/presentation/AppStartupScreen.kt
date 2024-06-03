package com.example.articlesappandroid.appstartup.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.articlesappandroid.appstartup.application.AppStartupViewModel
import com.example.articlesappandroid.appstartup.application.AppStartupState
import com.example.articlesappandroid.navigation.AuthRoute


@Composable
fun AppStartupScreen(navController: NavController) {
    val viewModel: AppStartupViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    when (state) {
        AppStartupState.INITIAL -> {
            //Do nothing
        }

        AppStartupState.AUTHORIZED -> {
            //Move to dashboard
        }

        AppStartupState.UNAUTHORIZED -> {
            navController.navigate(AuthRoute)
        }
    }
}
