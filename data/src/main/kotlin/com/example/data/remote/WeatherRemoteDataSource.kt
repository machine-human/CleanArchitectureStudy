package com.example.data.remote

import android.util.Log
import com.example.data.WeatherDataSource
import com.example.data.network.api.WeatherApi
import com.example.response.WeatherResponse
import com.luxrobo.ext.applySingleScheduler
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