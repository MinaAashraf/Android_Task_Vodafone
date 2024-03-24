package com.android_task_vodafone.data.sources.Mappers

import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.core.utils.formatDate
import com.android_task_vodafone.core.utils.generateUrlFromIconCode
import com.android_task_vodafone.data.sources.model.data.CurrentWeatherDTO

fun CurrentWeatherDTO.toDomain(): WeatherInfo {

    return WeatherInfo(
        time = time.formatDate(),
        temp = temp,
        humidity = humidity,
        windSpeed = windSpeed,
        pressure = pressure,
        cityName = cityName,
        iconUrl = weatherIconWithDescription.iconCode.generateUrlFromIconCode(),
        description = weatherIconWithDescription.description

    )
}

