package com.android_task_vodafone.features.city_input.domain.repository

interface CityNameRepository {
    suspend fun storeCityNameLocally (cityName:String)
}