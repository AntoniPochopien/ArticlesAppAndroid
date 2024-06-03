package com.example.articlesappandroid.auth.domain

import com.example.articlesappandroid.auth.infrastructure.LoginRequest
import com.example.articlesappandroid.common.domain.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IAuthApi {
    @POST("/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<User>

    @GET("/auth/exist")
    suspend fun checkUsername():Response<Map<String,Boolean>>
}