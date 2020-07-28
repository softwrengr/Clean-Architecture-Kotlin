package com.example.architecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturekotlin.R
import com.example.cleanarchitecturekotlin.databinding.ActivityLoginBinding
import com.example.architecture.models.LoginResponse
import com.example.architecture.utils.hide
import com.example.architecture.utils.show
import com.example.architecture.utils.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding:ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onLoading() {
       progess.show()
    }

    override fun onSuccess(loginResponse: LiveData<LoginResponse>) {
        loginResponse.observe(this, Observer {
            progess.hide()
            if(it.success){
                toast(it.message)
            }
            else{
                toast(it.message)
            }
        })
    }

    override fun onFailure(message: String) {
        progess.hide()
        toast(message)
    }
}