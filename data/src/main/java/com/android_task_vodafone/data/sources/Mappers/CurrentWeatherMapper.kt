package com.android_task_vodafone.data.sources.Mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.core.utils.generateUrlFromIconCode
import com.android_task_vodafone.data.sources.model.curret_weather.CurrentWeatherDto
import com.android_task_vodafone.weatherlib.WeatherInfoFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun CurrentWeatherDto.toDomain(): WeatherInfo {

    return WeatherInfo(
        time = WeatherInfoFormatter.formatDate(time),
        temp = temp,
        humidity = humidity,
        windSpeed = windSpeed,
        pressure = pressure,
        cityName = cityName,
        iconUrl = WeatherInfoFormatter.formatIconUrl(
            weatherIconWithDescription.iconCode
        ),
        description = weatherIconWithDescription.description

    )
}

