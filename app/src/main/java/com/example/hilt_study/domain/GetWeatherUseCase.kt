package com.example.hilt_study.domain

import android.util.Log
import com.example.hilt_study.data.WeatherRepository
import com.example.hilt_study.network.response.WeatherResponse
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class WeatherUseCaseImpl @Inject constructor(
    private val weatherRepository: WeatherRepository
): GeneralUseCase<WeatherResponse, MainUseCaseParam> {

    override fun invoke(
        params: MainUseCaseParam,
        success: (WeatherResponse) -> Unit,
        failed: (Throwable) -> Unit
    ): Disposable {
        Log.v("machine-human","WeatherUseCaseImpl -> invoke()")
        return weatherRepository.getData(location = params.location, success, failed)
    }
}

data class MainUseCaseParam(
    val location: String
)