package com.example.architecture.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture.models.faqModel.FaqDataModel
import com.example.architecture.models.faqModel.FaqResponse
import com.example.architecture.repository.Repository
import com.example.architecture.utils.ApiException
import com.example.architecture.utils.NoInternetException
import kotlinx.coroutines.launch

class EmployeeViewModel(private val repository: Repository) : ViewModel() {

    val faqList: LiveData<List<FaqDataModel>?> = MutableLiveData()

    init {

        viewModelScope.launch {
            faqList as MutableLiveData
            faqList.value = getEmployee()?.data
        }
    }

    private suspend fun getEmployee(): FaqResponse {
        val response = repository.getFaq()

        response.let {
            return it
        }
    }
}