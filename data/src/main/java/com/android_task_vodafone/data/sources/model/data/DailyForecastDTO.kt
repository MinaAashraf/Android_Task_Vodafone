package com.android_task_vodafone.data.sources.model.data

import com.google.gson.annotations.SerializedName

data class DailyForecastDTO (
    @SerializedName("valid_date")
    val time : String,
    @SerializedName ("temp")
    val temp : Float,
    @SerializedName ("rh")
    val humidity : Float,
    @SerializedName ("wind_spd")
    val windSpeed : Float,
    @SerializedName ("pres")
    val pressure : Float,
    @SerializedName ("weather")
    val weatherIconWithDescription : WeatherIconWithDescriptionDTO
)