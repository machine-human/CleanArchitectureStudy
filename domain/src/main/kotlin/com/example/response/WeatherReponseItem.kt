package com.example.response

data class WeatherReponseItem(
    val latt_long: String,
    val location_type: String,
    val title: String,
    val woeid: Int
)