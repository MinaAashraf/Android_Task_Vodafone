package com.android_task_vodafone.features.forecast.domain.repository

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.features.forecast.domain.model.Forecast

interface ForecastRepository  {
    suspend fun getForecasts (cityName:String) : Result<List<Forecast>>
}