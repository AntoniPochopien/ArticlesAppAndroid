package com.example.articlesappandroid.dashboard.domain

import com.example.articlesappandroid.common.domain.SimpleUser
import kotlinx.serialization.Serializable

@Serializable
data class Article (
    val id: Int,
    val title: String,
    val content: String,
    val owner: SimpleUser,
    val images:List<String>
)