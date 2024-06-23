package com.example.articlesappandroid.auth.infrastructure

import android.util.Log
import com.example.articlesappandroid.auth.domain.IAuthRepository
import com.example.articlesappandroid.common.domain.Either
import com.example.articlesappandroid.common.domain.Failure
import com.example.articlesappandroid.common.domain.User
import com.example.articlesappandroid.common.helpers.ErrorHandler
import com.example.articlesappandroid.common.retrofit.RetrofitInstance

class AuthRepository(private val retrofitInstance: RetrofitInstance):IAuthRepository {
    override suspend fun login(username: String, password: String): Either<Failure, User> {
        try{
            val response = retrofitInstance.authApi.login(AuthRequest(username, password))
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
            Log.v("login","login unexpected error $e")
            return Either.Left(Failure.Unexpected)
        }
    }

    override suspend fun register(username: String, password: String): Either<Failure, Unit> {
        try{
            val response = retrofitInstance.authApi.register(AuthRequest(username, password))
            return ErrorHandler.getFailureFromStatusCode(response.code(), "register")
        }catch (e:Exception){
            Log.v("register","register unexpected error $e")
            return Either.Left(Failure.Unexpected)
        }
    }

    override suspend fun checkUsername(username: String): Either<Failure, Unit> {
        try{
            val response = retrofitInstance.authApi.checkUsername(username)
            return ErrorHandler.getFailureFromStatusCode(response.code(), "checkUsername").fold(
                left = {
                        Either.Left(it)
                },
                right = {
                    val exist = response.body()!!["exist"] as Boolean
                    if(exist){
                        Either.Left(Failure.NotUnique)
                    }else{
                        Either.Right(Unit)
                    }
                }
            )
        }catch(e:Exception){
            Log.v("checkUsername","checkUsername unexpected error $e")
            return Either.Left(Failure.Unexpected)
        }
    }
}