package com.example.architecture.models.login

import com.example.architecture.models.login.LoginData

data class LoginResponse(
    val success:Boolean,
    val status:Int,
    val message:String,
    var loginData: LoginData
)