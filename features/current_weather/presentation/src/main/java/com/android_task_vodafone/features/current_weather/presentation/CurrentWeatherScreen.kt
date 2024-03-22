
package com.android_task_vodafone.features.current_weather.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CurrentWeatherScreen(
    modifier: Modifier = Modifier,
    currentWeatherState: CurrentWeatherState
) {

    Scaffold(
        topBar = {
            Column(modifier = modifier.fillMaxWidth().height(40.dp)) {
                Text(text = "Cairo")
            }
        }
    ) {
           Column (modifier.padding(it)) {

           }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCurrentWeatherScreen() {
      CurrentWeatherScreen(Modifier,CurrentWeatherState())
}
