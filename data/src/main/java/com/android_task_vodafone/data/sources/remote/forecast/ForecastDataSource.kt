package com.android_task_vodafone.data.sources.remote.forecast

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.data.sources.model.forecast.ForecastDto

interface ForecastDataSource {
    suspend fun getForecasts (citName:String) : Result<List<ForecastDto>>
}