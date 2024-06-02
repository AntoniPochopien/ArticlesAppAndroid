package com.example.articlesappandroid

import android.app.Application

class ArticlesApp: Application() {
    companion object {
        lateinit var di:DI
    }

    override fun onCreate(){
        super.onCreate()
        di = DI(this)
    }
}