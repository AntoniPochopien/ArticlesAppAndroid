package com.example.articlesappandroid.common.domain

sealed class Either<out L, out R> {
    data class Left<out L>(val value: L):Either<L, Nothing>()
    data class Right<out R>(val value: R):Either<Nothing, R>()

    fun isLeft():Boolean = this is Left<L>
    fun isRight():Boolean = this is Right<R>

    fun<L> left(value: L) = Left(value)
    fun<R> right(value: R) = Right(value)
}