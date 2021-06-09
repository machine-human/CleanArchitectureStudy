package com.example.hilt_study.data

import com.example.hilt_study.network.response.WeatherResponse
import io.reactivex.rxjava3.disposables.Disposable

interface WeatherRepository {

    fun getData(
        location: String,
        success: (WeatherResponse) -> Unit,
        failed: (Throwable) -> Unit
    ): Disposable

    fun setData(data: Boolean)
}