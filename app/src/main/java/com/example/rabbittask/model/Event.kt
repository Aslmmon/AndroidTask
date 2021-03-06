package com.example.rabbittask.model

data class Event(
    val address: String,
    val arabic_description: String,
    val arabic_name: String,
    val arabic_short_description: String,
    val categories: List<Category>,
    val city: CityX,
    val city_id: Int,
    val description: String,
    val end_date: String,
    val facebook: String,
    val features: List<Feature>,
    val id: Int,
    val instagram: String,
    val lat: Any,
    val lng: Any,
    val name: String,
    val offers: List<Any>,
    val photos: List<String>,
    val price_per_day: String,
    val short_description: String,
    val start_date: String,
    val ticket_price: String,
    val twitter: String,
    val video_preview: String,
    val views: Int,
    val website: Any,
    val whole_price: String
)