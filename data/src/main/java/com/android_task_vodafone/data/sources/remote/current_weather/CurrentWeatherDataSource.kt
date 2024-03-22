package com.android_task_vodafone.data.sources.remote.current_weather

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.data.sources.model.curret_weather.CurrentWeatherDto
import com.android_task_vodafone.data.sources.model.curret_weather.WeatherResponse

interface CurrentWeatherDataSource {
  suspend fun getCurrentWeatherData (cityName:String) : Result<CurrentWeatherDto>
}