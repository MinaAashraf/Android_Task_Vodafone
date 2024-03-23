package com.android_task_vodafone.features.forecast.presentation

sealed class ForecastEvent {
    data object OnRefresh : ForecastEvent( )
}