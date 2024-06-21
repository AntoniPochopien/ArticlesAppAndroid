package com.example.articlesappandroid

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.example.articlesappandroid.auth.domain.IAuthRepository
import com.example.articlesappandroid.auth.infrastructure.AuthRepository
import com.example.articlesappandroid.common.domain.AuthenticatedUser
import com.example.articlesappandroid.common.domain.User
import com.example.articlesappandroid.common.retrofit.RetrofitInstance
import com.example.articlesappandroid.localstorage.domain.ILocalStorageRepository
import com.example.articlesappandroid.localstorage.infrastructure.LocalStorageRepository

class DI (private val appContext: Context){

    private val retrofit by lazy{
        RetrofitInstance
    }
    val authRepository: IAuthRepository by lazy{
        AuthRepository(retrofit)
    }
    val localStorageRepository:ILocalStorageRepository by lazy{
        LocalStorageRepository(appContext)
    }
    val authenticatedUser by lazy{
        AuthenticatedUser(User.none())
    }
}