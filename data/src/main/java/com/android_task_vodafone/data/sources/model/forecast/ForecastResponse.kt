package com.android_task_vodafone.data.sources.model.forecast

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("data")
    val forecast : List<DailyForecastDto?>?
)
