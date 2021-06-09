package com.example.data.network.api

import com.example.response.WeatherResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("location/search")
    fun getWeatherData(
        @Query("query") query: String
    ): Single<WeatherResponse>

    companion object {
        val API_BASE_URL = "https://www.metaweather.com/api/"
    }
}