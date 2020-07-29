package com.example.architecture.repository

import com.example.architecture.models.LoginResponse
import com.example.architecture.network.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class Repository {

    suspend fun userLogin(email:String,password:String) : Response<LoginResponse>{

        return withContext(Dispatchers.IO){
            ApiInterface().userLogin(email,password)
        }

    }
}