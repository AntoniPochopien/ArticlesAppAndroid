package com.example.articlesappandroid.common.retrofit

import com.example.articlesappandroid.auth.domain.IAuthApi
import com.example.articlesappandroid.common.constants.Api
import com.example.articlesappandroid.dashboard.domain.IDashboardApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private inline fun <reified T> createApi(): T {
        return Retrofit.Builder()
            .baseUrl(Api.url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(T::class.java)
    }

    val authApi: IAuthApi by lazy {
        createApi<IAuthApi>()
    }
    val dashboardApi: IDashboardApi by lazy{
        createApi<IDashboardApi>()
    }
}