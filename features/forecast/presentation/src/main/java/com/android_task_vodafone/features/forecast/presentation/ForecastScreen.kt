package com.android_task_vodafone.features.forecast.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android_task_vodafone.core.utils.composables.WeatherInfoItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForecastScreen(
    modifier: Modifier = Modifier,
    forecastUiState: ForecastUiState,
    cityName : String,
    onEvent: (event: ForecastEvent) -> Unit
) {

    LaunchedEffect(Unit) {
        onEvent(ForecastEvent.OnRefresh(cityName))
    }

    Box(modifier.fillMaxSize()) {
        if (forecastUiState.isLoading)
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        else if (!forecastUiState.errorMessage.isNullOrEmpty())
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = forecastUiState.errorMessage.toString())
            }
        else if (forecastUiState.forecast.isNotEmpty()) {
            LazyColumn(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                contentPadding = PaddingValues(20.dp)
            ) {
                items(forecastUiState.forecast) {
                    WeatherInfoItem(weather = it)
                }
            }
        }
    }
}