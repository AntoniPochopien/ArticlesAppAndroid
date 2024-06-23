package com.example.articlesappandroid.dashboard.infrastructure

import android.util.Log
import com.example.articlesappandroid.common.constants.Api
import com.example.articlesappandroid.common.domain.AuthenticatedUser
import com.example.articlesappandroid.common.domain.Either
import com.example.articlesappandroid.common.domain.Failure
import com.example.articlesappandroid.common.helpers.ErrorHandler
import com.example.articlesappandroid.common.retrofit.RetrofitInstance
import com.example.articlesappandroid.dashboard.domain.Article
import com.example.articlesappandroid.dashboard.domain.Filters
import com.example.articlesappandroid.dashboard.domain.IDashboardRepository

class DashboardRepository(private val retrofitInstance: RetrofitInstance, private val authenticatedUser: AuthenticatedUser) : IDashboardRepository {
    override suspend fun getArticles(page: Int, filter: Filters): Either<Failure, List<Article>> {
        try{
        val response = retrofitInstance.dashboardApi.getArticles(Api.headers(authenticatedUser.user.accessToken, false) ,page, filter.ordinal)
        return ErrorHandler.getFailureFromStatusCode(response.code(), "getArticles").fold(
            left = {
                Either.Left(it)
            },
            right = {
                Either.Right(response.body()?.content ?: emptyList())
            }
        )
        }catch (e:Exception){
            Log.v("getArticles","getArticles unexpected error $e")
            return  Either.Left(Failure.Unexpected)
        }
    }

    override suspend fun removeArticle(articleId: Int): Either<Failure, Unit> {
        TODO("Not yet implemented")
    }
}