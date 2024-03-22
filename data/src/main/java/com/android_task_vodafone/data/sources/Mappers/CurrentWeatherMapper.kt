package com.android_task_vodafone.data.sources.Mappers

import com.android_task_vodafone.data.sources.model.CurrentWeatherDto
import com.android_task_vodafone.features.current_weather.domain.model.Weather

fun CurrentWeatherDto.toDomain() : Weather {
  return Weather(
      time = time,
      temp = temp,
      humidity = humidity,
      windSpeed = windSpeed,
      pressure = pressure,
      cityName = cityName,
      iconUrl = generateIconUrl(weatherIconWithDescription.iconCode),
      description = weatherIconWithDescription.description
  )
}

private fun generateIconUrl (iconCode:String) = "https://cdn.weatherbit.io/static/img/icons/$iconCode.png"