package com.android_task_vodafone.features.current_weather.domain.model

data class Weather(
    val time : String,
    val temp : Float,
    val humidity : Float,
    val windSpeed : Float,
    val pressure : Float,
    val cityName : String,
    val iconUrl : String,
    val description : String
)
