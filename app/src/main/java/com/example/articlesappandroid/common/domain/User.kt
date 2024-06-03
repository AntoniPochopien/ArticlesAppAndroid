package com.example.articlesappandroid.common.domain

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class User (
    val id:String,
    val username:String,
    val accessToken:String,
){
    companion object {
        fun none() = User(id = "", username = "", accessToken = "")

        fun fromJson(jsonString: String): User {
            return Json.decodeFromString(jsonString)
        }
    }
}