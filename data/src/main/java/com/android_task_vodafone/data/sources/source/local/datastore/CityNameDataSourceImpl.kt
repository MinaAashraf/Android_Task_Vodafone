package com.android_task_vodafone.data.sources.source.local.datastore

import android.content.Context
import com.android_task_vodafone.data.sources.utils.DataStoreKeys
import com.android_task_vodafone.data.sources.utils.cityDataStore
import com.android_task_vodafone.data.sources.utils.getStringFlow
import com.android_task_vodafone.data.sources.utils.setString
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CityNameDataSourceImpl @Inject constructor(@ApplicationContext private val context:Context) :
    CityNameDataSource {
    override suspend fun setCityName(cityName: String) {
        context.cityDataStore.setString(DataStoreKeys.CITY_NAME,cityName)
    }

    override fun getCityName(): Flow<String?> = context.cityDataStore.getStringFlow(DataStoreKeys.CITY_NAME)
}