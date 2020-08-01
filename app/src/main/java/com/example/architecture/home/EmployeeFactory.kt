package com.example.architecture.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.repository.Repository

@Suppress("UNCHECKED_CAST")
class EmployeeFactory(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EmployeeViewModel(repository) as T
    }

}