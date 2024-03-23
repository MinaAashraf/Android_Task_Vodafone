package com.android_task_vodafone.di

import com.android_task_vodafone.data.sources.repository.cityname.CityNameRepositoryImpl
import com.android_task_vodafone.data.sources.repository.current_weather.CurrentWeatherRepositoryImpl
import com.android_task_vodafone.data.sources.repository.forecast.ForecastRepositoryImpl
import com.android_task_vodafone.features.city_input.domain.repository.CityNameRepository
import com.android_task_vodafone.features.current_weather.domain.repository.CurrentWeatherRepository
import com.android_task_vodafone.features.forecast.domain.repository.ForecastRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindCurrentWeatherRepository(currentWeatherRepositoryImpl: CurrentWeatherRepositoryImpl): CurrentWeatherRepository

    @Binds
    fun bindForecastRepository(forecastRepositoryImpl: ForecastRepositoryImpl): ForecastRepository

    @Binds
    fun bindCityNameRepository(cityNameRepositoryImpl: CityNameRepositoryImpl): CityNameRepository

}