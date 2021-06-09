package com.example.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.domain.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUsecase: GetWeatherUseCase
): ViewModel() {

    fun getWeatherData() {
        Log.v("machine-human","WeatherViewModel -> getWeatherData()")
        weatherUsecase.invoke(
            params = com.example.domain.MainUseCaseParam(location = "san"),
            success = {
                Log.v("machine-human","WeatherViewModel -> getWeatherData() -> success -> $it")
            } ,
            failed = {
                Log.v("machine-human","WeatherViewModel -> getWeatherData() -> failed -> $it")
            }
        )
    }
}