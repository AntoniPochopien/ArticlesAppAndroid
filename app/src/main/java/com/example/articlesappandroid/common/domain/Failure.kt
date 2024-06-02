package com.example.articlesappandroid.common.domain

sealed class Failure {
    data object CannotReach : Failure()
    data object Forbidden : Failure()
    data object Unauthorized : Failure()
    data object NotUnique : Failure()
    data object Unexpected : Failure()
}