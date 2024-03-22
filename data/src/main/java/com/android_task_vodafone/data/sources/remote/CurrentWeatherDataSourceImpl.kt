package com.android_task_vodafone.data.sources.remote

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.data.sources.client_service.WeatherService
import com.android_task_vodafone.data.sources.model.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CurrentWeatherDataSourceImpl @Inject constructor(private val weatherService: WeatherService) :
    CurrentWeatherDataSource {
    override suspend fun getCurrentWeatherData(cityName:String): Result<WeatherResponse> {
        return try {
            withContext(Dispatchers.IO) {
                Result.Success(weatherService.getCurrentWeatherData(cityName))
            }
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }

}