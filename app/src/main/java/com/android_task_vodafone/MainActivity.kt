package com.android_task_vodafone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android_task_vodafone.features.city_input.presentation.CityInputScreen
import com.android_task_vodafone.features.city_input.presentation.CityInputViewModel
import com.android_task_vodafone.features.current_weather.presentation.CurrentWeatherScreen
import com.android_task_vodafone.features.current_weather.presentation.CurrentWeatherViewModel
import com.android_task_vodafone.features.forecast.presentation.ForecastScreen
import com.android_task_vodafone.features.forecast.presentation.ForecastViewModel
import com.android_task_vodafone.navigation.MyApp
import com.android_task_vodafone.ui.theme.Android_Task_VodafoneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_Task_VodafoneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp(rememberNavController())
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMyApp() {
    Android_Task_VodafoneTheme {
        MyApp(rememberNavController())
    }
}