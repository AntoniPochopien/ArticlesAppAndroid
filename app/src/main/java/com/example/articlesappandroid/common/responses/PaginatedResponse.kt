package com.example.articlesappandroid.common.responses

import kotlinx.serialization.Serializable

@Serializable
data class PaginatedResponse<T>(
    val content: List<T>
)