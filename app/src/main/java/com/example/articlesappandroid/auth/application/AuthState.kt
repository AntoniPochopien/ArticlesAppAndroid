package com.example.articlesappandroid.auth.application

import com.example.articlesappandroid.common.domain.Failure

sealed class AuthState {
    data object Initial : AuthState()
    data object RegisterSuccess : AuthState()
    data object Authorized : AuthState()
    data object Loading : AuthState()
    data class Error(val reason: Failure) : AuthState()
}