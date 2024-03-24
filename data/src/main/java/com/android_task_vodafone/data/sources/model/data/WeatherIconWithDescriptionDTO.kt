package com.android_task_vodafone.data.sources.model.data

import com.google.gson.annotations.SerializedName

data class WeatherIconWithDescriptionDTO (
    @SerializedName("icon")
    val iconCode : String?,
    @SerializedName("description")
    val description : String
)