package com.android_task_vodafone.core.utils

data class WeatherInfo(
    val time: String = "",
    val temp: Float = 0f,
    val humidity: Float = 0f,
    val windSpeed: Float = 0f,
    val pressure: Float = 0f,
    val cityName: String = "",
    val iconUrl: String = "",
    val description: String = ""
)
