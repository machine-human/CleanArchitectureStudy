package com.example.hilt_study.data.repositories

import android.util.Log
import com.example.hilt_study.data.WeatherDataSource
import com.example.hilt_study.data.WeatherRepository
import com.example.hilt_study.network.response.WeatherResponse
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDataSource: WeatherDataSource
) : WeatherRepository {

    override fun getData(
        location: String,
        success: (WeatherResponse) -> Unit,
        failed: (Throwable) -> Unit
    ): Disposable {
        Log.v("machine-human", "WeatherRepositoryImpl -> getData()")
        return weatherDataSource.getData(location, success, failed)
    }

    override fun setData(data: Boolean) {

    }
}