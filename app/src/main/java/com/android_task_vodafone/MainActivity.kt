package com.android_task_vodafone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android_task_vodafone.features.current_weather.presentation.CurrentWeatherScreen
import com.android_task_vodafone.features.current_weather.presentation.CurrentWeatherViewModel
import com.android_task_vodafone.features.forecast.domain.model.Forecast
import com.android_task_vodafone.features.forecast.presentation.ForecastScreen
import com.android_task_vodafone.features.forecast.presentation.ForecastViewModel
import com.android_task_vodafone.ui.theme.Android_Task_VodafoneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentWeatherViewModel: CurrentWeatherViewModel by viewModels()
            val currentWeatherState by currentWeatherViewModel.currentWeatherState.collectAsState()
            val forecastViewModel: ForecastViewModel by viewModels()
            val forecastUiState by forecastViewModel.forecastUiState.collectAsState()


            Android_Task_VodafoneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ForecastScreen(forecastUiState = forecastUiState)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_Task_VodafoneTheme {
    }
}