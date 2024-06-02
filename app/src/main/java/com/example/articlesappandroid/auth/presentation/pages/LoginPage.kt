package com.example.articlesappandroid.auth.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.articlesappandroid.common.composables.ArticlesInput

@Composable
fun LoginPage(){
    var username by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }

    Column() {
        ArticlesInput(hint = "Username", value = username){
            username = it
        }
        ArticlesInput(hint = "Password", value = password, obscure = true){
            password = it
        }
    }
}