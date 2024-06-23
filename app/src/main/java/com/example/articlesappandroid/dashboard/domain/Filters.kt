package com.example.articlesappandroid.dashboard.domain

enum class Filters {
    ALL,
    MINE
}

fun Filters.getName():String{
   return when(this){
        Filters.ALL -> "All"
        Filters.MINE -> "Mine"
    }
}