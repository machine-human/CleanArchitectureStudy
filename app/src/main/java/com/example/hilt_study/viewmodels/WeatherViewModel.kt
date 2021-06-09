package com.example.hilt_study.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.hilt_study.domain.MainUseCaseParam
import com.example.hilt_study.domain.WeatherUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUsecase: WeatherUseCaseImpl
): ViewModel() {

    fun getWeatherData() {
        Log.v("machine-human","WeatherViewModel -> getWeatherData()")
        weatherUsecase.invoke(
            params = MainUseCaseParam(location = "san"),
            success = {
                Log.v("machine-human","WeatherViewModel -> getWeatherData() -> success -> $it")
            } ,
            failed = {
                Log.v("machine-human","WeatherViewModel -> getWeatherData() -> failed -> $it")
            }
        )
    }
}