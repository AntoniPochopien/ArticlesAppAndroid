package com.example.articlesappandroid.dashboard.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articlesappandroid.dashboard.domain.Filters
import com.example.articlesappandroid.dashboard.domain.IDashboardRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(private val dashboardRepository: IDashboardRepository): ViewModel() {
    private val _state = MutableStateFlow<DashboardState>(DashboardState.Initial)
    val state: StateFlow<DashboardState> = _state

    fun fetchData(filters: Filters){
        viewModelScope.launch {
            _state.value = DashboardState.Loading
            val result = dashboardRepository.getArticles(0, filters)
            result.fold(
                left = {
                    _state.value = DashboardState.Error(it)
                },
                right = {
                    _state.value = DashboardState.Data(it, false, 0, emptyList())
                }
            )
        }
    }
}