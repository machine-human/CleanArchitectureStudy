package com.example.data.repositories

import android.util.Log
import com.example.data.WeatherDataSource
import com.example.response.WeatherResponse
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDataSource: WeatherDataSource
) : com.example.domain.WeatherRepository {

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