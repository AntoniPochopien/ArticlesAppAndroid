package com.example.articlesappandroid.dashboard.domain

import com.example.articlesappandroid.common.responses.PaginatedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface IDashboardApi {
    @GET("/articles")
    suspend fun getArticles(
        @HeaderMap headers: Map<String,String>,
        @Query("page") page:Int, @Query("filter") filters: Int): Response<PaginatedResponse<Article>>
}