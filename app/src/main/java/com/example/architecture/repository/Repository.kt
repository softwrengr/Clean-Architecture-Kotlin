package com.example.architecture.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.architecture.models.LoginResponse
import com.example.architecture.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun userLogin(email:String,password:String) : LiveData<LoginResponse>{
        val loginResponse = MutableLiveData<LoginResponse>()

        ApiInterface().userLogin(email,password)
            .enqueue(object :Callback<LoginResponse>{
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                   if(response.isSuccessful){
                       loginResponse.value = response.body()
                   }
                }

            })

        return loginResponse
    }
}