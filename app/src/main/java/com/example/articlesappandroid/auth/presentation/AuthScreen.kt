package com.example.articlesappandroid.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import com.example.articlesappandroid.auth.presentation.pages.LoginPage
import com.example.articlesappandroid.auth.presentation.pages.RegisterPage
import com.example.articlesappandroid.constants.Dim

@Composable
fun AuthScreen() {
    var isLogin by remember { mutableStateOf(value = true) }
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(all = Dim.screenPadding.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(isLogin){
                LoginPage()
            }else{
                RegisterPage()
            }
            Button(onClick = {
            //TODO register or logIn user
             }) {
                Text(text = if(isLogin){
                    "Login"
                }else{
                    "Register"
                })
            }
            TextButton(onClick = { isLogin = !isLogin }) {
                Text(text = if(isLogin){
                    "Register"
                }else{
                    "Login"
                })
            }
        }
    }
}