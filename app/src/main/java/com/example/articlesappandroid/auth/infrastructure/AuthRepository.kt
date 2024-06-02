package com.example.articlesappandroid.auth.infrastructure

import com.example.articlesappandroid.auth.domain.IAuthRepository
import com.example.articlesappandroid.common.domain.Either
import com.example.articlesappandroid.common.domain.Failure
import com.example.articlesappandroid.common.domain.User

class AuthRepository:IAuthRepository {
    override suspend fun login(username: String, password: String): Either<Failure, User> {
        TODO("Not yet implemented")
    }

    override suspend fun register(username: String, password: String): Either<Failure, Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun checkUsername(login: String): Either<Failure, Unit> {
        TODO("Not yet implemented")
    }
}