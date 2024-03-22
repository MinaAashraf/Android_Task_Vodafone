package com.android_task_vodafone.data.sources.remote.current_weather

import android.util.Log
import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.data.sources.client_service.WeatherService
import com.android_task_vodafone.data.sources.exceptions.DataNotFoundException
import com.android_task_vodafone.data.sources.model.curret_weather.CurrentWeatherDto
import com.android_task_vodafone.data.sources.model.curret_weather.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CurrentWeatherDataSourceImpl @Inject constructor(private val weatherService: WeatherService) :
    CurrentWeatherDataSource {
    override suspend fun getCurrentWeatherData(cityName: String): Result<CurrentWeatherDto> {
        return withContext(Dispatchers.IO) {
            try {
                val currentWeatherDataList = weatherService.getCurrentWeatherData(cityName).currentWeatherData
                if (!currentWeatherDataList.isNullOrEmpty()) Result.Success(currentWeatherDataList[0])
                else Result.Failure(DataNotFoundException())

            } catch (e: Exception) {
                Log.d("networkErr:", e.message.toString())
                Result.Failure(e)
            }
        }
    }

}