package com.android_task_vodafone.features.current_weather.presentation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.core.utils.composables.WeatherInfoItem
import com.android_task_vodafone.core.utils.generateUrlFromIconCode

@Composable
fun CurrentWeatherScreen(
    modifier: Modifier = Modifier,
    currentWeatherState: CurrentWeatherState,
    currentCityState: String,
    getCurrentWeatherEvent: (cityName: String) -> Unit,
) {

    LaunchedEffect(currentCityState) {
        if (currentCityState.isNotEmpty())
            getCurrentWeatherEvent(currentCityState)
    }

    if (currentWeatherState.isLoading)
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    else if (!currentWeatherState.errorMessage.isNullOrEmpty())
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = currentWeatherState.errorMessage.toString())
        }
    else if (currentWeatherState.currentWeather != null) {
        WeatherInfoItem(
            modifier = modifier,
            cityName = currentCityState,
            weather = currentWeatherState.currentWeather
        )
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewCurrentWeatherScreen() {
    CurrentWeatherScreen(
        Modifier,
        CurrentWeatherState(
            currentWeather = WeatherInfo(
                "2024-04-06",
                temp = 12f,
                windSpeed = 1f,
                humidity = 10f,
                cityName = "Cairo",
                iconUrl = "c01d".generateUrlFromIconCode(),
                pressure = 22f,
                description = ""
            ),
        ),
        currentCityState = "Ciro"
    ) {}
}
