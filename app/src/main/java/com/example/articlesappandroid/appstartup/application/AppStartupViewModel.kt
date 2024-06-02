package com.example.articlesappandroid.appstartup.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articlesappandroid.appstartup.domain.AppStartupState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppStartupViewModel : ViewModel() {

    private val _state = MutableStateFlow(AppStartupState.INITIAL)
    val state: StateFlow<AppStartupState> = _state

    init {
        initializeApp()
    }

    private fun initializeApp() {
        viewModelScope.launch {
            _state.value = AppStartupState.UNAUTHORIZED
        }
    }
}