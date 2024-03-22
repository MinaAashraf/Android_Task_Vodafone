package com.android_task_vodafone.features.current_weather.presentation

import com.android_task_vodafone.features.current_weather.domain.model.Weather

data class CurrentWeatherState(
    val isLoading: Boolean = false,
    val currentWeather: Weather? = null,
    val errorMessage: String? = null,
    )