package com.example.domain

import android.util.Log
import com.example.response.WeatherResponse
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
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