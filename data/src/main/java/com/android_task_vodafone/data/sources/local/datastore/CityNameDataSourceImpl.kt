package com.android_task_vodafone.data.sources.local.datastore

import android.content.Context
import com.android_task_vodafone.data.sources.utils.DataStoreKeys
import com.android_task_vodafone.data.sources.utils.cityDataStore
import com.android_task_vodafone.data.sources.utils.getString
import com.android_task_vodafone.data.sources.utils.setString

class CityNameDataSourceImpl (private val context:Context) : CityNameDataSource {
    override suspend fun setCityName(cityName: String) {
        context.cityDataStore.setString(DataStoreKeys.CITY_NAME,cityName)
    }

    override fun getCityName(): String? = context.cityDataStore.getString(DataStoreKeys.CITY_NAME)
}