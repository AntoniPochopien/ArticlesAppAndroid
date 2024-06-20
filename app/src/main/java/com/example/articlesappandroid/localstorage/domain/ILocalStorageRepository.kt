package com.example.articlesappandroid.localstorage.domain

import com.example.articlesappandroid.common.domain.User

interface ILocalStorageRepository {
    suspend fun readUser():User?
    suspend fun updateUser(user:User?)
}