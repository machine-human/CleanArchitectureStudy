package com.example.hilt_study.di

import com.example.data.remote.WeatherDataSource
import com.example.data.repositories.WeatherRepositoryImpl
import com.example.domain.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    // Repository
    @Provides
    @ViewModelScoped
    fun provideWeatherRepository(
        dataSource: WeatherDataSource
    ): WeatherRepository =
        WeatherRepositoryImpl(weatherDataSource = dataSource)
}