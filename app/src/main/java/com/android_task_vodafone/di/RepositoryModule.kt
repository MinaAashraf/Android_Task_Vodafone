package com.android_task_vodafone.di

import com.android_task_vodafone.data.sources.remote.CurrentWeatherDataSource
import com.android_task_vodafone.data.sources.remote.CurrentWeatherDataSourceImpl
import com.android_task_vodafone.data.sources.repository.CurrentWeatherRepositoryImpl
import com.android_task_vodafone.features.current_weather.domain.repository.CurrentWeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindCurrentWeatherRepository(currentWeatherRepositoryImpl: CurrentWeatherRepositoryImpl): CurrentWeatherRepository

}