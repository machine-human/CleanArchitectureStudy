package com.example.hilt_study.di

import com.example.data.network.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class DataSourceModule {

    // DataSource
    @Provides
    @ViewModelScoped
    fun provideWeatherDataSource(
        api: WeatherApi
    ): com.example.data.WeatherDataSource =
        com.example.data.remote.WeatherRemoteDataSource(weatherApi = api)
}