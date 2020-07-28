package com.example.architecture.network

import com.example.architecture.models.LoginResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface{

    @FormUrlEncoded
    @POST("signup/login")
    fun userLogin(
      @Field("email") email:String,
      @Field("password") passwrod:String
    ) : Call<LoginResponse>

    companion object{
        operator fun invoke() : ApiInterface {
            return Retrofit.Builder()
                .baseUrl("http://3.135.160.209/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }
    }
}