package com.android_task_vodafone.data.sources.remote.forecast

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.data.sources.model.forecast.DailyForecastDto

interface ForecastDataSource {
    suspend fun getForecast (citName:String) : Result<List<DailyForecastDto>>
}