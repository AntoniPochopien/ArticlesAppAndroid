package com.example.articlesappandroid.auth.application

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {
    private val _state = MutableStateFlow(AuthState.Initial)
    val state: StateFlow<AuthState> = _state


}