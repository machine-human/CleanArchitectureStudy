package com.example.hilt_study.di

import com.example.hilt_study.data.WeatherDataSource
import com.example.hilt_study.data.WeatherRepository
import com.example.hilt_study.data.remote.WeatherRemoteDataSource
import com.example.hilt_study.data.repositories.WeatherRepositoryImpl
import com.example.hilt_study.network.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class DataSourceModule {

    // DataSource
    @Provides
    @ViewModelScoped
    fun provideWeatherDataSource(
        api: WeatherApi
    ): WeatherDataSource = WeatherRemoteDataSource(weatherApi = api)
}