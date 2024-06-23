package com.example.articlesappandroid.common.domain

import kotlinx.serialization.Serializable

@Serializable
data class SimpleUser(
    val id:String,
    val username:String,
)
