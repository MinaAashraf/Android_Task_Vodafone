package com.android_task_vodafone.data.sources.client_service

import com.android_task_vodafone.data.sources.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("current")
    suspend fun getCurrentWeatherData(
        @Query("city") cityName: String
    ): WeatherResponse

    @GET("forecast/daily")
    suspend fun getForeCastWeatherData(
        @Query("city") cityName: String
    ): WeatherResponse


}