package com.android_task_vodafone.data.sources.repository

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.data.sources.Mappers.toDomain
import com.android_task_vodafone.data.sources.remote.CurrentWeatherDataSource
import com.android_task_vodafone.features.current_weather.domain.model.Weather
import com.android_task_vodafone.features.current_weather.domain.repository.CurrentWeatherRepository
import javax.inject.Inject

class CurrentWeatherRepositoryImpl @Inject constructor(private val currentWeatherDataSource: CurrentWeatherDataSource) :
    CurrentWeatherRepository {
    override suspend fun getCurrentWeather(cityName: String): Result<Weather> =
        when (val result = currentWeatherDataSource.getCurrentWeatherData(cityName)){
            is Result.Success -> Result.Success(result.data.currentWeatherData[0].toDomain())
            is Result.Failure -> result
        }
}