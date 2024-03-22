package com.android_task_vodafone.di

import com.android_task_vodafone.data.sources.remote.CurrentWeatherDataSource
import com.android_task_vodafone.data.sources.remote.CurrentWeatherDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourcesModule {
    @Binds
    fun bindCurrentWeatherDataSource(currentWeatherDataSourceImpl : CurrentWeatherDataSourceImpl): CurrentWeatherDataSource

}