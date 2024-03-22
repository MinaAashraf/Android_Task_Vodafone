package com.android_task_vodafone.data.sources.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("data")
    val currentWeatherData : List<CurrentWeatherDto>,
    @SerializedName("current_units")
    val conditionUnits : CurrentWeatherDto,

)
