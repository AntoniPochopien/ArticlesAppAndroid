package com.example.articlesappandroid.dashboard.domain

import com.example.articlesappandroid.common.domain.Either
import com.example.articlesappandroid.common.domain.Failure


interface IDashboardRepository {
    suspend fun  getArticles(
     page:Int, filter:Filters): Either<Failure, List<Article>>

    suspend fun removeArticle(articleId: Int): Either<Failure, Unit>
}