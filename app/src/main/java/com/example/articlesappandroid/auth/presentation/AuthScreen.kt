package com.example.articlesappandroid.auth.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.articlesappandroid.ArticlesApp
import com.example.articlesappandroid.auth.application.AuthState
import com.example.articlesappandroid.auth.application.AuthViewModel
import com.example.articlesappandroid.auth.presentation.pages.LoginPage
import com.example.articlesappandroid.auth.presentation.pages.RegisterPage
import com.example.articlesappandroid.common.helpers.viewModelFactory
import com.example.articlesappandroid.constants.Dim
import com.example.articlesappandroid.navigation.DashboardRoute
import kotlinx.coroutines.coroutineScope

@Composable
fun AuthScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current
    var isLogin by remember { mutableStateOf(value = true) }
    val interactionSource = remember { MutableInteractionSource() }
    val viewModel = viewModel<AuthViewModel>(
        factory =  viewModelFactory {
            AuthViewModel(ArticlesApp.di.authRepository, ArticlesApp.di.authenticatedUser)
        }
    )
    val state by viewModel.state.collectAsStateWithLifecycle()

    if(state == AuthState.Authorized){
        navController.navigate(DashboardRoute)
    }else if(state == AuthState.RegisterSuccess){
        isLogin = true
    }

    Scaffold(modifier = Modifier.clickable(
        interactionSource = interactionSource,
        indication = null
    ) {
        focusManager.clearFocus()
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState())
                .imePadding()
                .padding(all = Dim.screenPadding.dp),
            contentAlignment = Alignment.Center
        ) {
            Column {
                if (isLogin) {
                    LoginPage(
                        state = state,
                        onLogin = { username, password ->
                            viewModel.login(username, password)
                        },
                        onModeChange = {
                            isLogin = !isLogin
                        }
                    )
                } else {
                    RegisterPage(
                        viewModel = viewModel,
                        state = state,
                        onModeChange = {
                        isLogin = !isLogin
                    })
                }
            }
        }
    }
}