package com.android_task_vodafone.data.sources.remote.forecast

import android.util.Log
import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.data.sources.client_service.WeatherService
import com.android_task_vodafone.data.sources.exceptions.DataNotFoundException
import com.android_task_vodafone.data.sources.model.forecast.ForecastDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ForecastDataSourceImpl @Inject constructor(private val weatherService: WeatherService) :
    ForecastDataSource {
    override suspend fun getForecasts(cityName: String): Result<List<ForecastDto>> {
        return withContext(Dispatchers.IO) {
            try {
                val forecastData = weatherService.getForecastWeatherData(cityName).forecast
                if (!forecastData.isNullOrEmpty()) Result.Success(forecastData)
                else Result.Failure(DataNotFoundException())
            } catch (e: Exception) {
                Log.d("networkErr:", e.message.toString())
                Result.Failure(e)
            }
        }
    }
}