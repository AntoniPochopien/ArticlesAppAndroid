package com.example.articlesappandroid.auth.domain

import com.example.articlesappandroid.auth.infrastructure.AuthRequest
import com.example.articlesappandroid.common.domain.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface IAuthApi {
    @POST("/auth/login")
    suspend fun login(@Body authRequest: AuthRequest): Response<User>

    @POST("/auth/register")
    suspend fun register(@Body authRequest:AuthRequest): Response<Unit>

    @GET("/users/exist")
    suspend fun checkUsername(@Query("username") username:String):Response<Map<String,Boolean>>

}