package com.android_task_vodafone.data.sources.utils

import android.content.Context
import android.provider.ContactsContract.Data
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

val Context.cityDataStore: DataStore<Preferences> by preferencesDataStore(name = DataStoreKeys.CITY_NAME_PREF)

fun DataStore<Preferences>.getStringFlow(key: String): Flow<String?> {
    val dataStore: DataStore<Preferences> = this
    val stringKey = stringPreferencesKey(key)
    return dataStore.data.map { preferences: Preferences ->
        preferences[stringKey]
    }
}

suspend fun DataStore<Preferences>.setString(key: String, value: String) {
    val booleanKey = stringPreferencesKey(key)
    edit { preferences ->
        preferences[booleanKey] = value
    }
}
