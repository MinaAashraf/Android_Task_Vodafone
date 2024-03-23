package com.android_task_vodafone.features.forecast.presentation

sealed class ForecastEvent {
    data class OnRefresh (val cityName:String) : ForecastEvent()
}