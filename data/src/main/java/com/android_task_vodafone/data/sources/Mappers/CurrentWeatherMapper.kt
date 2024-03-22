package com.android_task_vodafone.data.sources.Mappers

import com.android_task_vodafone.core.utils.generateUrlFromIconCode
import com.android_task_vodafone.data.sources.model.curret_weather.CurrentWeatherDto
import com.android_task_vodafone.features.current_weather.domain.model.Weather

fun CurrentWeatherDto.toDomain() : Weather {
  return Weather(
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

