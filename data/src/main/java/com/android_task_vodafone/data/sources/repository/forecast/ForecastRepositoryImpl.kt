package com.android_task_vodafone.data.sources.repository.forecast

import android.util.Log
import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.data.sources.Mappers.toDomainList
import com.android_task_vodafone.data.sources.remote.forecast.ForecastDataSource
import com.android_task_vodafone.features.forecast.domain.repository.ForecastRepository
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(private val forecastDataSource: ForecastDataSource) :
    ForecastRepository {
    override suspend fun getForecast(cityName: String): Result<List<WeatherInfo>> {
        return when (val result = forecastDataSource.getForecast(cityName)) {
            is Result.Success -> {
                Log.d("forecast data", result.data.toString())
                Result.Success(result.data.toDomainList())}
            is Result.Failure -> result
        }
    }
}