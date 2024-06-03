package com.example.articlesappandroid.auth.infrastructure

import com.example.articlesappandroid.auth.domain.IAuthRepository
import com.example.articlesappandroid.common.domain.Either
import com.example.articlesappandroid.common.domain.Failure
import com.example.articlesappandroid.common.domain.User
import com.example.articlesappandroid.common.helpers.ErrorHandler
import com.example.articlesappandroid.common.retrofit.RetrofitInstance

class AuthRepository(private val retrofitInstance: RetrofitInstance):IAuthRepository {
    override suspend fun login(username: String, password: String): Either<Failure, User> {
        try{
            val response = retrofitInstance.api.login(LoginRequest(username, password))
            return ErrorHandler.getFailureFromStatusCode(response.code(), "login").fold(
                left = {
                    Either.Left(it)
                },
                right = {
                    val user = response.body()
                    Either.Right(user!!)
                }
            )
        }catch (e:Exception){
            return Either.Left(Failure.Unexpected)
        }
    }

    override suspend fun register(username: String, password: String): Either<Failure, Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun checkUsername(login: String): Either<Failure, Unit> {
        TODO("Not yet implemented")
    }
}