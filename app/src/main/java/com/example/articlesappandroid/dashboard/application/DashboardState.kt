package com.example.articlesappandroid.dashboard.application

import com.example.articlesappandroid.common.domain.Failure
import com.example.articlesappandroid.dashboard.domain.Article

sealed class DashboardState {
    data object Initial : DashboardState()
    data class Data(val articles : List<Article>,
                    val morePagesLoading: Boolean,
                    val actualPage: Int,
                    val deletingInProgressArticleIds: List<Int>
        ): DashboardState()
    data object Loading : DashboardState()
    data class Error(val reason: Failure) : DashboardState()
    data object Logout:DashboardState()
}