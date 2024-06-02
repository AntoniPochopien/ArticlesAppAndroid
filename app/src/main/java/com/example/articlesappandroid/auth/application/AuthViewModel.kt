package com.example.articlesappandroid.auth.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articlesappandroid.auth.infrastructure.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _state = MutableStateFlow<AuthState>(AuthState.Initial)
    val state: StateFlow<AuthState> = _state

    fun login() {
        viewModelScope.launch {
            val x = AuthRepository().login("asd", "sad");
            x.fold(left = {
                _state.value = AuthState.Error(it)
            }, right = {

            })
        }
    }

}