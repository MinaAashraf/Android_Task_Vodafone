package com.android_task_vodafone.data.sources.model.response

import com.android_task_vodafone.data.sources.model.data.DailyForecastDTO
import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("data")
    val forecast : List<DailyForecastDTO?>?
)
