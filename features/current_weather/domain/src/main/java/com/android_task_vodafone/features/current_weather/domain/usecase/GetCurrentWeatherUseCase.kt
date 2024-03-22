package com.android_task_vodafone.features.current_weather.domain.usecase

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.features.current_weather.domain.model.Weather
import com.android_task_vodafone.features.current_weather.domain.repository.CurrentWeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(private val currentWeatherRepository: CurrentWeatherRepository) {
    suspend operator fun invoke(cityName: String): Result<Weather> =
        currentWeatherRepository.getCurrentWeather(cityName)
}