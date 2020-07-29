package com.example.architecture.ui

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.architecture.repository.Repository
import com.example.architecture.utils.ApiException
import com.example.architecture.utils.Coroutines
import com.example.architecture.utils.NoInternetException

class LoginViewModel(private val repository: Repository) : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginClicked(view: View) {
        authListener?.onLoading()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("invalid email or password")
            return
        }

        Coroutines.Main {
            try {
                val loginResponse = repository.userLogin(email!!, password!!)

                loginResponse.let {
                    authListener?.onSuccess(it)
                    return@Main
                }
                authListener?.onFailure(loginResponse.message!!)

            } catch (ex: ApiException) {
                authListener?.onFailure(ex.message!!)
            } catch (ex: NoInternetException) {
                authListener?.onFailure(ex.message!!)
            }
        }


    }
}