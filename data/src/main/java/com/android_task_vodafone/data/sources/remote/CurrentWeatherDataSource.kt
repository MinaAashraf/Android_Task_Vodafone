package com.android_task_vodafone.data.sources.remote

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.data.sources.model.WeatherResponse

interface CurrentWeatherDataSource {
  suspend fun getCurrentWeatherData (cityName:String) : Result<WeatherResponse>
}