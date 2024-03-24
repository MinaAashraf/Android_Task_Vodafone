package com.android_task_vodafone

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.features.city_input.presentation.CityInputScreen
import com.android_task_vodafone.features.current_weather.presentation.CurrentWeatherScreen
import com.android_task_vodafone.features.current_weather.presentation.CurrentWeatherState
import com.android_task_vodafone.navigation.NavItem

@Composable
fun CurrentWeatherWithSearchScreen(
    modifier: Modifier = Modifier,
    currentCityState: String,
    firstTimeState: Boolean,
    onConfirmBtnClick: (searchQuery: String) -> Unit,
    currentWeatherState: CurrentWeatherState,
    getCurrentWeatherEvent: (cityName: String) -> Unit,
    navController: NavHostController
) {
    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp),
    ) {

        CityInputScreen(onConfirmBtnClick = onConfirmBtnClick)

        Spacer(modifier = modifier.height(60.dp))

        if (!firstTimeState)
            CurrentWeatherScreen(
                modifier = Modifier,
                currentWeatherState = currentWeatherState,
                currentCityState = currentCityState,
                getCurrentWeatherEvent = getCurrentWeatherEvent,
            )
        else
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = stringResource(R.string.enter_you_city),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                )
            }
        Spacer(modifier = modifier.height(20.dp))

        if (currentWeatherState.currentWeather != null && !currentWeatherState.isLoading) {
            BottomRow(modifier, currentCityState, navController)

        }
    }
}

@Composable
fun BottomRow(
    modifier: Modifier = Modifier,
    currentCityState: String,
    navController: NavHostController
) {
    Row(
        modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.today),
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold

        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier.clickable { navController.navigate("${NavItem.Forecast.route}/${currentCityState}") },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.next_7_days),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.width(2.dp))
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "",
                Modifier.size(30.dp)
            )
        }
    }
}


@Preview
@Composable
fun PreviewMainScreen() {
    CurrentWeatherWithSearchScreen(
        currentCityState = "Cairo",

        onConfirmBtnClick = { },
        currentWeatherState = CurrentWeatherState(
            currentWeather = WeatherInfo("22/3/2024", 10f, 20f, 30f, 40f, "cairo", "", "")
        ),
        firstTimeState = false,
        getCurrentWeatherEvent = {},
        navController = rememberNavController()
    )
}