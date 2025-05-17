package com.example.vanderapp.Screen.Api

sealed class Result<T> (
    val data: T? = null,
    val message: String? = null
){
    class success<T>(data: T?): Result<T>(data)
    class Loading(message: String?): Result<String>(message = message)
    class Error<T>(data: T?=null, message: String?): Result<T>(data= data, message=message)
}