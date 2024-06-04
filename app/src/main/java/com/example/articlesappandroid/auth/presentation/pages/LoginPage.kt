package com.example.articlesappandroid.auth.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.articlesappandroid.auth.application.AuthState
import com.example.articlesappandroid.common.composables.ArticlesCircularProgressIndicator
import com.example.articlesappandroid.common.composables.ArticlesInput

@Composable
fun LoginPage(
    state: AuthState,
    onLogin: (String, String) -> Unit,
    onModeChange: () -> Unit
) {
    var username by remember { mutableStateOf(value = "") }
    var usernameError by remember { mutableStateOf(value = false) }
    var password by remember { mutableStateOf(value = "") }
    var passwordError by remember { mutableStateOf(value = false) }

    val isLoading = state == AuthState.Loading

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArticlesInput(hint = "Username", value = username, isError = usernameError) {
            username = it
            usernameError = it.isEmpty()
        }
        ArticlesInput(
            hint = "Password",
            value = password,
            obscure = true,
            isError = passwordError
        ) {
            password = it
            passwordError = it.isEmpty()
        }
        Button(onClick = {
            onLogin(username, password)
        }) {
            if (isLoading) {
                ArticlesCircularProgressIndicator()
            } else {
                Text(
                    text =
                    "Login"
                )
            }


        }

        TextButton(onClick = { onModeChange() }) {
            Text(
                text =
                "Register"
            )
        }
    }
}