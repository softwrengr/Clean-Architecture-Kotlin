package com.example.architecture.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.adapter.FaqAdapter
import com.example.architecture.models.faqModel.FaqResponse
import com.example.architecture.network.ApiInterface
import com.example.architecture.network.NetworkConnectionInterceptor
import com.example.architecture.repository.Repository
import com.example.architecture.ui.LoginViewModelFactory
import com.example.architecture.utils.hide
import com.example.architecture.utils.show
import com.example.architecture.utils.toast
import com.example.cleanarchitecturekotlin.R
import com.example.cleanarchitecturekotlin.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val adaper by lazy { FaqAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)

        val networkConnectionInterceptor = NetworkConnectionInterceptor(this)
        val apiInterface = ApiInterface(networkConnectionInterceptor)
        val repository = Repository(apiInterface)
        val factory = EmployeeFactory(repository)

        val viewModel = ViewModelProvider(this,factory).get(EmployeeViewModel::class.java)
        viewModel.faqList.observe(this, Observer {
            adaper.setEmployeeItem(it)
            recyclerview.adapter = adaper
        })

    }

}