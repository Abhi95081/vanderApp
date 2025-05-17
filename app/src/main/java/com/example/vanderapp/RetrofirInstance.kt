package com.example.vanderapp

import com.example.vanderapp.Screen.Api.API_BUIILDER
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofirInstance {

    var clint: OkHttpClient = OkHttpClient.Builder().build()

    val api: API_BUIILDER = Retrofit.Builder()
        .client(clint)
        .baseUrl(API_BUIILDER.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(API_BUIILDER::class.java)
}