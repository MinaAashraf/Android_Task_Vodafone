package com.android_task_vodafone.di

import com.android_task_vodafone.data.sources.source.local.datastore.CityNameDataSource
import com.android_task_vodafone.data.sources.source.local.datastore.CityNameDataSourceImpl
import com.android_task_vodafone.data.sources.source.remote.current_weather.CurrentWeatherDataSource
import com.android_task_vodafone.data.sources.source.remote.current_weather.CurrentWeatherDataSourceImpl
import com.android_task_vodafone.data.sources.source.remote.forecast.ForecastDataSource
import com.android_task_vodafone.data.sources.source.remote.forecast.ForecastDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourcesModule {
    @Binds
    fun bindCurrentWeatherDataSource(currentWeatherDataSourceImpl : CurrentWeatherDataSourceImpl): CurrentWeatherDataSource

    @Binds
    fun bindForecastDataSource(forecastDataSourceImpl: ForecastDataSourceImpl): ForecastDataSource

    @Binds
    fun bindCityNameDataSource(cityNameDataSourceImpl: CityNameDataSourceImpl): CityNameDataSource

}