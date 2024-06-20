package com.example.articlesappandroid.auth.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articlesappandroid.auth.domain.IAuthRepository
import com.example.articlesappandroid.common.domain.AuthenticatedUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authRepository: IAuthRepository,
    private val authenticatedUser: AuthenticatedUser,
) : ViewModel() {
    private val _state = MutableStateFlow<AuthState>(AuthState.Initial)
    val state: StateFlow<AuthState> = _state

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _state.value = AuthState.Loading
            val result = authRepository.login(username, password);
            result.fold(
                left = {
                    _state.value = AuthState.Error(it)
                },
                right = {
                    authenticatedUser.updateUser(it)
                    _state.value = AuthState.Authorized
                })
        }
    }

    fun register(username: String, password: String) {
        viewModelScope.launch {
            _state.value = AuthState.Loading
            val result = authRepository.register(username, password)
            result.fold(
                left = {
                    _state.value = AuthState.Error(it)
                },
                right = {
                    _state.value = AuthState.RegisterSuccess
                })
        }
    }

    fun checkUsername(username: String) {
        viewModelScope.launch {
            _state.value = AuthState.Loading
            val result = authRepository.checkUsername(username)
            result.fold(
                left = {
                    _state.value = AuthState.Error(it)
                },
                right = {
                    _state.value = AuthState.Initial
                })
        }
    }
}