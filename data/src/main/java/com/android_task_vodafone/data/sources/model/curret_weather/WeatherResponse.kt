package com.android_task_vodafone.data.sources.model.curret_weather

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("data")
    val currentWeatherData : List<CurrentWeatherDto>?,

    )
