package com.example.vanderapp.Screen.Api

import kotlinx.coroutines.flow.Flow

interface CreateuserRepo {

    suspend fun createuser(): Flow<Result<usercreateresponse>>
}