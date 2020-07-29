package com.example.architecture.ui

import com.example.architecture.models.LoginResponse

interface AuthListener {
    fun onLoading();
    fun onSuccess(loginResponse: LoginResponse?)
    fun onFailure(message: String);
}