package com.android_task_vodafone.features.forecast.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ForecastScreen(modifier: Modifier = Modifier, forecastUiState: ForecastUiState) {
    Box(modifier.fillMaxSize()) {
        if (forecastUiState.errorMessage.isNullOrEmpty())
            Text(forecastUiState.forecast.toString())
        else
            Text(forecastUiState.errorMessage)

    }
}