package com.example.architecture.models

data class LoginResponse(
    val success:Boolean,
    val status:Int,
    val message:String,
    var loginData: LoginData)