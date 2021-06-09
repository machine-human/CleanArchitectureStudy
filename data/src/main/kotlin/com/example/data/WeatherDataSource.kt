package com.example.data

import com.example.response.WeatherResponse
import io.reactivex.rxjava3.disposables.Disposable

interface WeatherDataSource {

    fun getData(
        location: String,
        success: (WeatherResponse) -> Unit,
        failed: (Throwable) -> Unit
    ): Disposable
}