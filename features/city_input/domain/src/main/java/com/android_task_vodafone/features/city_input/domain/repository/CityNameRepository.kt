package com.android_task_vodafone.features.city_input.domain.repository

import kotlinx.coroutines.flow.Flow

interface CityNameRepository {
    suspend fun storeCityNameLocally (cityName:String)

     fun getCityNameFromLocal () : Flow<String?>
}