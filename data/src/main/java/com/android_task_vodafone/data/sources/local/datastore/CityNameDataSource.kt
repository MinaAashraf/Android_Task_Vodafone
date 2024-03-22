package com.android_task_vodafone.data.sources.local.datastore

interface CityNameDataSource {
    suspend fun setCityName (cityName:String)
    fun getCityName() : String?
}