package com.android_task_vodafone.features.current_weather.domain.repository

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.core.utils.WeatherInfo

interface CurrentWeatherRepository  {
    suspend fun getCurrentWeather (cityName:String) : Result<WeatherInfo>
}