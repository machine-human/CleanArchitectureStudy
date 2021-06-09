package com.example.hilt_study.network.response

data class WeatherReponseItem(
    val latt_long: String,
    val location_type: String,
    val title: String,
    val woeid: Int
)