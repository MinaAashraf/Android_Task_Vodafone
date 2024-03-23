package com.android_task_vodafone.features.city_input.domain.usecase

import com.android_task_vodafone.features.city_input.domain.repository.CityNameRepository
import javax.inject.Inject

class StoreCityNameUseCase @Inject constructor(private val cityNameRepository: CityNameRepository) {
    suspend operator fun invoke(cityName: String) {
        cityNameRepository.storeCityNameLocally(cityName)
    }
}