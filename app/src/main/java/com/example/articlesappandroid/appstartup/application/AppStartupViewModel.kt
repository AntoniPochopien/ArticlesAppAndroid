package com.example.articlesappandroid.appstartup.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articlesappandroid.localstorage.domain.ILocalStorageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppStartupViewModel(
    private val localStorageRepository: ILocalStorageRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AppStartupState.INITIAL)
    val state: StateFlow<AppStartupState> = _state

    init {
        initializeApp()
    }

    private fun initializeApp() {
        viewModelScope.launch {
            val user = localStorageRepository.readUser()
            if(user!=null){
                _state.value = AppStartupState.AUTHORIZED
            }else{
                _state.value = AppStartupState.UNAUTHORIZED
            }
        }
    }
}