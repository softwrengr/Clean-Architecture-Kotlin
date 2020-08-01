package com.example.architecture.home

import com.example.architecture.models.faqModel.FaqResponse

interface EmployeeListener {
    fun onLoading()
    fun onSuccess(loginResponse: FaqResponse?)
    fun onFailure(message: String)
}