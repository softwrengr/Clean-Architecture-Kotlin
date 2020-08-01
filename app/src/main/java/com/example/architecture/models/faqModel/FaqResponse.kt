package com.example.architecture.models.faqModel

class FaqResponse(
    val success: Boolean,
    val message:String,
    val data: List<FaqDataModel>
)