package com.android_task_vodafone.core.utils

data class WeatherInfo(
    val time : String,
    val temp : Float,
    val humidity : Float,
    val windSpeed : Float,
    val pressure : Float,
    val cityName : String,
    val iconUrl : String,
    val description : String
)
