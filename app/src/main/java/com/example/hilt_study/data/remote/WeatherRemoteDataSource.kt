package com.example.hilt_study.data.remote

import android.util.Log
import com.example.hilt_study.data.WeatherDataSource
import com.example.hilt_study.ext.applySingleScheduler
import com.example.hilt_study.network.api.WeatherApi
import com.example.hilt_study.network.response.WeatherResponse
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class WeatherRemoteDataSource @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherDataSource {

    override fun getData(
        location: String,
        success: (WeatherResponse) -> Unit,
        failed: (Throwable) -> Unit
    ): Disposable {
        Log.v("machine-human", "WeatherRemoteDataSource -> getData()")

        return weatherApi.getWeatherData(
            query = location
        ).applySingleScheduler()
            .subscribe({
                success(it)
            }, {
                failed(it)
            })
    }
}