package com.android_task_vodafone.features.forecast.presentation

import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.features.forecast.domain.model.Forecast

data class ForecastUiState(
    val isLoading : Boolean = false,
    val forecast : List<WeatherInfo> = listOf(),
    val errorMessage : String? = null
)
