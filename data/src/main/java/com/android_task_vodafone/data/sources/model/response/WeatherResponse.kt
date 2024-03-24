package com.android_task_vodafone.data.sources.model.response

import com.android_task_vodafone.data.sources.model.data.CurrentWeatherDTO
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("data")
    val currentWeatherData : List<CurrentWeatherDTO>?,

    )
