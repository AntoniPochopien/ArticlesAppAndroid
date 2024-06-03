package com.example.articlesappandroid.common.domain

data class AuthenticatedUser(var user: User){
    fun updateUser(newUser:User){
        user = newUser
    }
}