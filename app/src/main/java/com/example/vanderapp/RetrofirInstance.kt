package com.example.vanderapp

import com.example.vanderapp.Screen.Api.API_BUILDER
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofirInstance {

    var clint: OkHttpClient = OkHttpClient.Builder().build()

    val api: API_BUILDER = Retrofit.Builder()
        .client(clint)
        .baseUrl(API_BUILDER.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(API_BUILDER::class.java)
}