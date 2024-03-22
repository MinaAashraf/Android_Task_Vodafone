package com.android_task_vodafone.data.sources.model.forecast

import com.android_task_vodafone.data.sources.model.shared.WeatherIconWithDescriptionDto
import com.google.gson.annotations.SerializedName

data class ForecastDto (
    @SerializedName("app_max_temp")
    val maxTemp : Float,
    @SerializedName("app_min_temp")
    val minTemp : Float,
    @SerializedName ("weather")
    val weatherIconWithDescription : WeatherIconWithDescriptionDto
)