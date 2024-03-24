package com.android_task_vodafone.data.sources.source.remote.current_weather

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.data.sources.model.data.CurrentWeatherDTO

interface CurrentWeatherDataSource {
  suspend fun getCurrentWeatherData (cityName:String) : Result<CurrentWeatherDTO>
}