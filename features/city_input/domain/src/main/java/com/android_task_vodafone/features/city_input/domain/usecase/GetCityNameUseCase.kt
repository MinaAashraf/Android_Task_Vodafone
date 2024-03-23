package com.android_task_vodafone.features.city_input.domain.usecase

import com.android_task_vodafone.features.city_input.domain.repository.CityNameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCityNameUseCase @Inject constructor(private val cityNameRepository: CityNameRepository) {
     operator fun invoke(): Flow<String?> = cityNameRepository.getCityNameFromLocal()

}