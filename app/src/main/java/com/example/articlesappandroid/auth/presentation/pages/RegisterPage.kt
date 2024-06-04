package com.example.articlesappandroid.auth.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.example.articlesappandroid.auth.application.AuthState
import com.example.articlesappandroid.auth.application.AuthViewModel
import com.example.articlesappandroid.common.composables.ArticlesCircularProgressIndicator
import com.example.articlesappandroid.common.composables.ArticlesInput
import com.example.articlesappandroid.common.domain.Failure

@Composable
fun RegisterPage(
    state: AuthState,
    viewModel: AuthViewModel,
    onModeChange: () -> Unit
) {

    var username by remember { mutableStateOf(value = "") }
    var usernameError by remember { mutableStateOf(value = false) }
    var password by remember { mutableStateOf(value = "") }
    var passwordError by remember { mutableStateOf(value = false) }
    var repeatedPassword by remember { mutableStateOf(value = "") }
    var repeatedPasswordError by remember { mutableStateOf(value = false) }

    val isLoading = state == AuthState.Loading

    if (state == AuthState.Error(Failure.NotUnique)) {
        usernameError=true
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArticlesInput(hint = "Username", value = username, isError = usernameError) {
            username = it
            usernameError = it.isEmpty() || it.length < 4
            if (!usernameError) {
                viewModel.checkUsername(username)
            }
        }
        ArticlesInput(
            hint = "Password",
            value = password,
            obscure = true,
            isError = passwordError
        ) {
            password = it
            passwordError = it.isEmpty() || it.length < 6
        }
        ArticlesInput(
            hint = "Repeat password",
            value = repeatedPassword,
            obscure = true,
            isError = repeatedPasswordError
        ) {
            repeatedPassword = it
            repeatedPasswordError = it.isEmpty() || it.length < 6
        }
        Button(
            enabled = !usernameError && !passwordError && !repeatedPasswordError,
            onClick = {
                if(password.isEmpty() || repeatedPassword.isEmpty() || repeatedPassword != password ){
                    repeatedPasswordError = true
                    passwordError = true
                }
            if (!usernameError && !passwordError && !repeatedPasswordError) {
                viewModel.register(username, password)
            }
        }) {
            if(isLoading){
                ArticlesCircularProgressIndicator()
            }else{
                Text(
                    text =
                    "Register"
                )
            }

        }

        TextButton(onClick = { onModeChange() }) {
            Text(
                text =
                "Login"
            )
        }
    }
}