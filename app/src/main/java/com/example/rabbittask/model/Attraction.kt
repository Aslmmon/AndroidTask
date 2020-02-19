package com.example.rabbittask.model

data class Attraction(
    val arabic_description: String,
    val arabic_name: String,
    val categories: List<Category>,
    val city: City,
    val description: String,
    val duration: String,
    val duration_unit: String,
    val exlcude: String,
    val facebook: Any,
    val features: List<Feature>,
    val general_terms: String,
    val id: Int,
    val instagram: Any,
    val is_active: Int,
    val lat: String,
    val lng: String,
    val markup: Int,
    val name: String,
    val offers: List<Any>,
    val photos: List<String>,
    val terms: String,
    val tryps_id: String,
    val twitter: Any,
    val working_hours: List<WorkingHour>
)