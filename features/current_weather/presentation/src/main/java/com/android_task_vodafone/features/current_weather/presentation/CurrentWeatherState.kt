package com.android_task_vodafone.features.current_weather.presentation

import com.android_task_vodafone.core.utils.WeatherInfo

data class CurrentWeatherState(
    val isLoading: Boolean = false,
    val currentWeather: WeatherInfo? = null,
    val errorMessage: String? = null,
    )
