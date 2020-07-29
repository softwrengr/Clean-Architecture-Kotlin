package com.example.architecture.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.repository.Repository

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory(private val repository: Repository):ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }

}