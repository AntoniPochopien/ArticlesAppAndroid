package com.example.articlesappandroid.common.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.articlesappandroid.common.constants.Dim

@Composable
fun ArticlesInput(
    value: String,
    hint: String,
    obscure: Boolean = false,
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dim.verticalPadding.dp),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = hint) },
        shape = RoundedCornerShape(percent = 20),
        visualTransformation = if (obscure) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        isError = isError
    )
}