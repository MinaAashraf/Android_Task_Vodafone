package com.android_task_vodafone.data.sources.Mappers

import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.core.utils.generateUrlFromIconCode
import com.android_task_vodafone.data.sources.model.curret_weather.CurrentWeatherDto

fun CurrentWeatherDto.toDomain() : WeatherInfo {
  return WeatherInfo(
      time = time,
      temp = temp,
      humidity = humidity,
      windSpeed = windSpeed,
      pressure = pressure,
      cityName = cityName,
      iconUrl = weatherIconWithDescription.iconCode.generateUrlFromIconCode(),
      description = weatherIconWithDescription.description
  )
}

