package com.example.articlesappandroid.common.domain

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

@Serializable
data class User (
    val id:String,
    val username:String,
    val accessToken:String,
){
    companion object {
        fun none() = User(id = "", username = "", accessToken = "")
    }
}