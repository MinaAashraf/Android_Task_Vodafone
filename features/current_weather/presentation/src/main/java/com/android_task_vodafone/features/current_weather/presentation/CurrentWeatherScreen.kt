package com.android_task_vodafone.features.current_weather.presentation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android_task_vodafone.features.current_weather.domain.model.Weather
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun CurrentWeatherScreen(
    modifier: Modifier = Modifier,
    currentWeatherState: CurrentWeatherState
) {
    if (currentWeatherState.currentWeather != null)
        Scaffold(
        ) {
            Column(
                modifier
                    .fillMaxWidth()
                    .padding(it), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = currentWeatherState.currentWeather.cityName)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = currentWeatherState.currentWeather.time)
                Spacer(modifier = Modifier.height(40.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Temp: ${currentWeatherState.currentWeather.temp}")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "humity: ${currentWeatherState.currentWeather.humidity}")
                }


            }
        }
    if (currentWeatherState.isLoading)
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    val scope = rememberCoroutineScope()
    val snackHostState = remember {
        SnackbarHostState()
    }
    if (!currentWeatherState.errorMessage.isNullOrEmpty())
        Scaffold(snackbarHost = {
            SnackbarHost(hostState = snackHostState)
        }) {
            Box(modifier = Modifier.padding(it)){
              /*  scope.launch {
                    snackHostState.showSnackbar(currentWeatherState.errorMessage)
                }*/
                Text(text = currentWeatherState.errorMessage)
            }
        }

}


@Preview(showBackground = true)
@Composable
fun PreviewCurrentWeatherScreen() {
    CurrentWeatherScreen(
        Modifier,
        CurrentWeatherState(
            currentWeather = Weather(
                "22/3/2024",
                temp = 12f,
                windSpeed = 1f,
                humidity = 10f,
                cityName = "Cairo",
                iconUrl = "",
                pressure = 22f,
                description = ""
            )
        )
    )
}
