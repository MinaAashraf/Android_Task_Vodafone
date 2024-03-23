package com.android_task_vodafone.features.current_weather.domain.usecase

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.features.current_weather.domain.repository.CurrentWeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(private val currentWeatherRepository: CurrentWeatherRepository) {
    suspend operator fun invoke(cityName: String): Result<WeatherInfo> =
        currentWeatherRepository.getCurrentWeather(cityName)
}