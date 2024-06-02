package com.example.articlesappandroid.auth.domain

import com.example.articlesappandroid.common.domain.Either
import com.example.articlesappandroid.common.domain.Failure

interface IAuthRepository {
     suspend fun login(username: String, password: String): Either<Failure, Unit>
     suspend fun register(username: String, password: String): Either<Failure, Unit>
     suspend fun checkUsername(login: String): Either<Failure, Unit>
}