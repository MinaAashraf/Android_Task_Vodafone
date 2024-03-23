package com.android_task_vodafone.data.sources.repository.current_weather

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.data.sources.Mappers.toDomain
import com.android_task_vodafone.data.sources.remote.current_weather.CurrentWeatherDataSource
import com.android_task_vodafone.features.current_weather.domain.repository.CurrentWeatherRepository
import javax.inject.Inject

class CurrentWeatherRepositoryImpl @Inject constructor(private val currentWeatherDataSource: CurrentWeatherDataSource) :
    CurrentWeatherRepository {
    override suspend fun getCurrentWeather(cityName: String): Result<WeatherInfo> =
        when (val result = currentWeatherDataSource.getCurrentWeatherData(cityName)){
            is Result.Success -> Result.Success(result.data.toDomain())
            is Result.Failure -> result
        }
}