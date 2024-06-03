package com.example.articlesappandroid.common.retrofit

import com.example.articlesappandroid.auth.domain.IAuthApi
import com.example.articlesappandroid.constants.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: IAuthApi by lazy {
        Retrofit.Builder().baseUrl(Api.url).addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IAuthApi::class.java)
    }
}