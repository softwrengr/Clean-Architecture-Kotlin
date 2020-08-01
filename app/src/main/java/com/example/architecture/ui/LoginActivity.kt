package com.example.architecture.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.home.HomeActivity
import com.example.architecture.models.login.LoginResponse
import com.example.architecture.network.ApiInterface
import com.example.architecture.network.NetworkConnectionInterceptor
import com.example.architecture.repository.Repository
import com.example.architecture.utils.hide
import com.example.architecture.utils.show
import com.example.architecture.utils.toast
import com.example.cleanarchitecturekotlin.R
import com.example.cleanarchitecturekotlin.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        val networkConnectionInterceptor = NetworkConnectionInterceptor(this)
        val apiInterface = ApiInterface(networkConnectionInterceptor)
        val repository = Repository(apiInterface)
        val factory = LoginViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.authListener = this
    }

    override fun onLoading() {
        progess.show()
    }

    override fun onSuccess(loginResponse: LoginResponse?) {
        progess.hide()
        toast(loginResponse!!.message)
        val newIntent = Intent(this, HomeActivity::class.java)
        startActivity(newIntent)
    }


    override fun onFailure(message: String) {
        progess.hide()
        toast(message)
    }
}