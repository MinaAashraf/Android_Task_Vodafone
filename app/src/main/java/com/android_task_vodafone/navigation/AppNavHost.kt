package com.android_task_vodafone.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.android_task_vodafone.CurrentWeatherWithSearchScreen
import com.android_task_vodafone.features.city_input.presentation.CityInputViewModel
import com.android_task_vodafone.features.current_weather.presentation.CurrentWeatherViewModel
import com.android_task_vodafone.features.forecast.presentation.ForecastEvent
import com.android_task_vodafone.features.forecast.presentation.ForecastScreen
import com.android_task_vodafone.features.forecast.presentation.ForecastViewModel

@Composable
fun MyApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavItem.CurrentWeatherWithSearch.route) {

        composable(route = NavItem.CurrentWeatherWithSearch.route) {
            val cityInputViewModel: CityInputViewModel = hiltViewModel()
            val cityNameState by cityInputViewModel.cityNameState.collectAsState()
            val currentWeatherViewModel: CurrentWeatherViewModel = hiltViewModel()
            val currentWeatherState by currentWeatherViewModel.currentWeatherState.collectAsState()

            CurrentWeatherWithSearchScreen(
                modifier = Modifier,
                cityInputState = cityNameState,
                onConfirmBtnClick = { searchQuery -> cityInputViewModel.storeCityName(searchQuery) },
                currentWeatherState = currentWeatherState,
                getCurrentWeatherEvent = { currentCityName ->
                    currentWeatherViewModel.getCurrentWeather(currentCityName)
                },
                navController = navController
            )
        }

        composable(
            route = "${NavItem.Forecast.route}/{${NavArgument.CityNameArg.name}}",
            arguments = listOf(navArgument(NavArgument.CityNameArg.name) { type = NavType.StringType })
        ) {
            val forecastViewModel: ForecastViewModel = hiltViewModel()
            val forecastUiState by forecastViewModel.forecastUiState.collectAsState()
            val onEvent = {event : ForecastEvent -> forecastViewModel.onEvent(event)}
            val cityName = it.arguments?.getString(NavArgument.CityNameArg.name)?:""
            ForecastScreen(
                forecastUiState = forecastUiState,
                cityName = cityName,
                onEvent = onEvent

            )
        }
    }


}