package com.example.articlesappandroid.common.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ArticlesCircularProgressIndicator(){
    CircularProgressIndicator(
        modifier = Modifier.size(20.dp),
        strokeWidth = 3.dp,
        color = Color.White)
}