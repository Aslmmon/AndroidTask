package com.example.rabbittask.model

data class HomePageContentResponse(
    val `data`: Data,
    val message: String,
    val status_code: Int
)