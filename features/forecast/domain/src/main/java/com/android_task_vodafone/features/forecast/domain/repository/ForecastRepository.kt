package com.android_task_vodafone.features.forecast.domain.repository

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.core.utils.WeatherInfo

interface ForecastRepository  {
    suspend fun getForecast (cityName:String) : Result<List<WeatherInfo>>
}