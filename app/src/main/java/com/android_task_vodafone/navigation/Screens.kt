package com.android_task_vodafone.navigation

enum class Screen {
    MainScreen,
    FORECAST
}
sealed class NavItem(val route: String) {
    object CurrentWeatherWithSearch : NavItem(Screen.MainScreen.name)
    object Forecast : NavItem(Screen.FORECAST.name)
}

sealed class NavArgument (val name : String){
  object CityNameArg : NavArgument ("cityName")
}