package com.example.architecture.network

import com.example.architecture.models.faqModel.FaqResponse
import com.example.architecture.models.login.LoginResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface{

    @FormUrlEncoded
    @POST("signup/login")
    suspend fun userLogin(
      @Field("email") email:String,
      @Field("password") passwrod:String
    ) : Response<LoginResponse>

    @GET("userapi/faqs")
    suspend fun getFaq():Response<FaqResponse>


    companion object{

        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor) : ApiInterface {

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl("http://3.135.160.209/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }
    }
}