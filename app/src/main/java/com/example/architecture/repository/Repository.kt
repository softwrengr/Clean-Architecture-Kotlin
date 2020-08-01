package com.example.architecture.repository

import com.example.architecture.models.faqModel.FaqResponse
import com.example.architecture.models.login.LoginResponse
import com.example.architecture.network.ApiInterface
import com.example.architecture.network.SafeApiRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val api: ApiInterface) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): LoginResponse {
        return withContext(Dispatchers.IO) {
            apiRequest { api.userLogin(email, password) }
        }
    }

    suspend fun getFaq(): FaqResponse {
        return withContext(Dispatchers.IO) {
            apiRequest { api.getFaq() }
        }
    }
}