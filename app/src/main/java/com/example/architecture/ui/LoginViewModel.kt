package com.example.architecture.ui

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture.repository.Repository
import com.example.architecture.utils.ApiException
import com.example.architecture.utils.Coroutines
import com.example.architecture.utils.NoInternetException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

        viewModelScope.launch {
            getUserData()
        }

    }

    private suspend fun getUserData() {
        try {
            val loginResponse = repository.userLogin(email!!, password!!)

            loginResponse.let {
                if (loginResponse.success) {
                    authListener?.onSuccess(it)
                    return
                }
                authListener?.onFailure(loginResponse.message!!)
            }


        } catch (ex: ApiException) {
            authListener?.onFailure(ex.message!!)
        } catch (ex: NoInternetException) {
            authListener?.onFailure(ex.message!!)
        }
    }
}