package com.android_task_vodafone.features.forecast.domain.usecase

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.features.forecast.domain.model.Forecast
import com.android_task_vodafone.features.forecast.domain.repository.ForecastRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(private val forecastRepository: ForecastRepository) {
    suspend operator fun invoke(cityName: String): Result<List<Forecast>> =
        when (val result = forecastRepository.getForecasts(cityName)){
             is Result.Success -> Result.Success(result.data.take(7))
             is Result.Failure -> result
        }

}