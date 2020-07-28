package com.example.architecture.ui

import androidx.lifecycle.LiveData
import com.example.architecture.models.LoginResponse

interface AuthListener {
    fun onLoading();
    fun onSuccess(loginResponse: LiveData<LoginResponse>);
    fun onFailure(message: String);
}