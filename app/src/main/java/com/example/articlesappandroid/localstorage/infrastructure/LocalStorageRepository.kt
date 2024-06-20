package com.example.articlesappandroid.localstorage.infrastructure

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.articlesappandroid.common.domain.User
import com.example.articlesappandroid.localstorage.domain.ILocalStorageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking


class LocalStorageRepository(
    private val appContext: Context
) : ILocalStorageRepository {
    private val Context.dataStore by preferencesDataStore(
        name = "ArticlesApp"
    )
    private val dataStore = appContext.dataStore

    private val USER_ID = stringPreferencesKey("user_id")
    private val USER_NAME = stringPreferencesKey("user_name")
    private val USER_TOKEN = stringPreferencesKey("user_token")

    override suspend fun readUser(): User? {
        try {
            val userFlow: Flow<User?> = dataStore.data.map { preferences ->
                User(
                    preferences[USER_ID]!!,
                    preferences[USER_NAME]!!,
                    preferences[USER_TOKEN]!!
                )
            }
            return runBlocking {
                userFlow.firstOrNull()
            }
        } catch (e: Exception) {
            return null
        }
    }

    override suspend fun updateUser(user: User?) {
        dataStore.edit { preferences ->
            if (user == null) {
                preferences.remove(USER_ID)
                preferences.remove(USER_NAME)
                preferences.remove(USER_TOKEN)
            } else {
                preferences[USER_ID] = user.id
                preferences[USER_NAME] = user.username
                preferences[USER_TOKEN] = user.accessToken
            }
        }
    }
}
