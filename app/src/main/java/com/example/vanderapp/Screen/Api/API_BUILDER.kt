package com.example.vanderapp.Screen.Api

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface API_BUILDER {

    @GET("/getAllusers")
    suspend fun getAllusers() : UserTest

    @FormUrlEncoded
    @POST("/createuser")
    suspend fun createuser(
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("address") address: String,
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("PinCode") pincode: String
    ): usercreateresponse

    companion object{
        const val BASE_URL = "http://127.0.0.1:5000"
    }
}
