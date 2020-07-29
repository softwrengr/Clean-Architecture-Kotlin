package com.example.architecture.network

import com.example.architecture.utils.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

abstract class SafeApiRequest {

    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>) :T {
       val response = call.invoke()

        if(response.isSuccessful){
            return response.body()!!
        }else{
            val error = response.errorBody()?.string()
            val message = StringBuilder()

            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                }catch (ex:JSONException){ }
                message.append("\n")
            }
            message.append("Error: {${response.code()}}")

            throw ApiException(message.toString())
        }

    }
}