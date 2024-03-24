package com.android_task_vodafone.data.sources.source.local.datastore

import kotlinx.coroutines.flow.Flow


interface CityNameDataSource {
    suspend fun setCityName (cityName:String)
    fun getCityName() : Flow<String?>

}