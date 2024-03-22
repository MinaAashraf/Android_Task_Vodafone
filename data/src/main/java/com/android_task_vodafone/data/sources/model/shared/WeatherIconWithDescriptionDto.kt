package com.android_task_vodafone.data.sources.model.shared

import com.google.gson.annotations.SerializedName

data class WeatherIconWithDescriptionDto (
    @SerializedName("icon")
    val iconCode : String,
    @SerializedName("description")
    val description : String
)