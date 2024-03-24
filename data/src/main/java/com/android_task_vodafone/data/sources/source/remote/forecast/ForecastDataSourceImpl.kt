package com.android_task_vodafone.data.sources.source.remote.forecast

import android.util.Log
import com.android_task_vodafone.core.utils.IoDispatcher
import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.data.sources.client_service.WeatherService
import com.android_task_vodafone.data.sources.exceptions.DataNotFoundException
import com.android_task_vodafone.data.sources.model.data.DailyForecastDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ForecastDataSourceImpl @Inject constructor(
    private val weatherService: WeatherService,
    @IoDispatcher private val dispatcher : CoroutineDispatcher
    ) :
    ForecastDataSource {
    override suspend fun getForecast(cityName: String): Result<List<DailyForecastDTO>> {
        return withContext(dispatcher) {
            try {
                val forecastData = weatherService.getForecastWeatherData(cityName)?.forecast?.filterNotNull()
                if (!forecastData.isNullOrEmpty()) Result.Success(forecastData)
                else Result.Failure(DataNotFoundException())
            } catch (e: Exception) {
                Log.d("networkErr:", e.message.toString())
                Result.Failure(e)
            }
        }
    }
}