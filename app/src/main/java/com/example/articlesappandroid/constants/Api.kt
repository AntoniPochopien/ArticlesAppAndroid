package com.example.articlesappandroid.constants

object Api {
    const val url = //"" //prod
    "http://10.0.2.2:8080" //android emulator
    //"http://192.168.1.240:8080"; //real device dev

    fun headers(
        token: String?,
        isMultiPart:Boolean = false
    ):Map<String,String>{
        val contentType = if(isMultiPart){
            "multipart/form-data"
        }else{
            "application/json"
        }
        return if(token != null){
            mapOf("Content-Type" to contentType, "Authorization" to "Bearer $token")
        }else{
            mapOf("Content-Type" to contentType)
        }
    }
}