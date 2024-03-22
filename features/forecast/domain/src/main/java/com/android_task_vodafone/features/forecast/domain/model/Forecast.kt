package com.android_task_vodafone.features.forecast.domain.model

data class Forecast(
    val maxTemp : Float,
    val minTemp : Float,
    val iconUrl : String,
    val description : String
)
