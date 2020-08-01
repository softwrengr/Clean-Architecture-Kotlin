package com.example.architecture.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.architecture.models.faqModel.FaqDataModel
import com.example.cleanarchitecturekotlin.R
import com.example.cleanarchitecturekotlin.databinding.CustomEmployeeLayoutBinding

class FaqAdapter : RecyclerView.Adapter<FaqAdapter.MyViewHolder>() {

    var employeeList: List<FaqDataModel>?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.custom_employee_layout,
            parent, false
        )
    )

    override fun getItemCount(): Int {
      return employeeList?.size?:0
    }

    fun setEmployeeItem(list: List<FaqDataModel>?){
        employeeList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.binding.employee = employeeList!![position]
    }

    inner class MyViewHolder(val binding: CustomEmployeeLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
}