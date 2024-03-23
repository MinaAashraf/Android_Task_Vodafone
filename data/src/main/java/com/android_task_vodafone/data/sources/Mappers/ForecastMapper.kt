package com.android_task_vodafone.data.sources.Mappers

import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.core.utils.generateUrlFromIconCode
import com.android_task_vodafone.data.sources.model.forecast.DailyForecastDto
import com.android_task_vodafone.features.forecast.domain.model.Forecast

fun DailyForecastDto.toDomain(): WeatherInfo {
    return WeatherInfo(
        time = time,
        temp = temp,
        humidity = humidity,
        windSpeed = windSpeed,
        pressure = pressure,
        cityName = "",
        iconUrl = weatherIconWithDescription.iconCode.generateUrlFromIconCode(),
        description = weatherIconWithDescription.description
    )
}

fun List<DailyForecastDto>.toDomainList(): List<WeatherInfo> {
    return map { it.toDomain() }
}