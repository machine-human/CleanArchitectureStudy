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
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    // Repository
    @Provides
    @ViewModelScoped
    fun provideWeatherRepository(
        dataSource: WeatherDataSource
    ): WeatherRepository = WeatherRepositoryImpl(weatherDataSource = dataSource)
}