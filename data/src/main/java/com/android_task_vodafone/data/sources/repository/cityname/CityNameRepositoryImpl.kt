package com.android_task_vodafone.data.sources.repository.cityname

import com.android_task_vodafone.data.sources.local.datastore.CityNameDataSource
import com.android_task_vodafone.features.city_input.domain.repository.CityNameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CityNameRepositoryImpl @Inject constructor(private val cityNameDataSource: CityNameDataSource) :
    CityNameRepository {
    override suspend fun storeCityNameLocally(cityName: String) =
        cityNameDataSource.setCityName(cityName)

    override fun getCityNameFromLocal(): Flow<String?> = cityNameDataSource.getCityName()


}