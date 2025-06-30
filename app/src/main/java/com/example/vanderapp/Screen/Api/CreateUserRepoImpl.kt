package com.example.vanderapp.Screen.Api

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CreateUserRepoImpl (
    private val api : API_BUILDER
) : CreateuserRepo{
    override suspend fun createuser(): Flow<Result<usercreateresponse>> {
        return flow {
           val userCreateResponse = try {
                api.createuser(
                    "Abhishek",
                    "123",
                    "abhirou7@gmail.com",
                    "Patna@bihar.com",
                    "9878634",
                    "78734"
                )
            }catch (e:Exception){
                emit(Result.Error(message = e.localizedMessage?.toString()))
                return@flow
            }
            emit( Result.success(userCreateResponse))

        }
    }
}