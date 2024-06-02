package com.example.articlesappandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.articlesappandroid.navigation.Navigation
import com.example.articlesappandroid.ui.theme.ArticlesAppAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticlesAppAndroidTheme {
                Navigation()
            }
        }
    }
}