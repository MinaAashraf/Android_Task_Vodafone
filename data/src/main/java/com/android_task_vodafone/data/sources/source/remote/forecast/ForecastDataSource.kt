package com.android_task_vodafone.data.sources.source.remote.forecast

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.data.sources.model.data.DailyForecastDTO

interface ForecastDataSource {
    suspend fun getForecast (citName:String) : Result<List<DailyForecastDTO>>
}