package com.example.architecture.ui

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.architecture.repository.Repository
import com.example.architecture.utils.Coroutines

class AuthViewModel :ViewModel(){
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginClicked(view : View){
        authListener?.onLoading()

        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("invalid email or password")
            return
        }

        Coroutines.Main {
            val loginResponse = Repository().userLogin(email!!,password!!)
            if(loginResponse.isSuccessful){
                authListener?.onSuccess(loginResponse.body())
            }
            else{
                authListener?.onFailure(loginResponse.message())
            }
        }


    }
}