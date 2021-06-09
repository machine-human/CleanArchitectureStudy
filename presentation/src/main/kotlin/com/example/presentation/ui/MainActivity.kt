package com.example.presentation.ui

import androidx.activity.viewModels
import com.example.presentation.R
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.viewModels.WeatherViewModel
import com.luxrobo.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val weatherViewModel by viewModels<WeatherViewModel>()

    override fun initializeUI() {
        weatherViewModel.getWeatherData()
    }
}