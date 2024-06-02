package com.example.articlesappandroid.auth.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AuthScreen(){
    Scaffold {
        Column(Modifier.padding(it)) {
            TextField(value = "asd", onValueChange = {}, label = { Text(text = "Login")})
        }
    }
}