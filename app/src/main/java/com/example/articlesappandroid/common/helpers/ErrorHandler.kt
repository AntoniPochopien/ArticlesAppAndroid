package com.example.articlesappandroid.common.helpers

import android.util.Log
import com.example.articlesappandroid.common.domain.Either
import com.example.articlesappandroid.common.domain.Failure

object ErrorHandler {
    fun getFailureFromStatusCode(statusCode: Int, source: String): Either<Failure, Unit> {
        Log.e(
            source, "${
                if (statusCode > 399) {
                    "error"
                } else {
                    "success"
                }
            }, statusCode: $statusCode"
        )
        return when (statusCode) {
            200, 201, 204, 302 -> Either.Right(Unit)
            404 -> Either.Left(Failure.CannotReach)
            401 -> Either.Left(Failure.Unauthorized)
            403 -> Either.Left(Failure.Forbidden)
            else -> Either.Left(Failure.Unexpected)
        }
    }
}