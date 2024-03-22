package com.android_task_vodafone.data.sources.model

import com.google.gson.annotations.SerializedName

data class ConditionUnits(
    @SerializedName("temperature_2m")
    val tempUnit : String,
    @SerializedName("relative_humidity_2m")
    val humidityUnit : String,
    @SerializedName("rain")
    val rainUnit : String,
    @SerializedName("wind_speed_10m")
    val windSpeedUnit : String
)
