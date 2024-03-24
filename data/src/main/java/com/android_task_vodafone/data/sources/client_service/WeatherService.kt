package com.android_task_vodafone.data.sources.client_service

import com.android_task_vodafone.core.utils.API_KEY
import com.android_task_vodafone.data.sources.model.response.WeatherResponse
import com.android_task_vodafone.data.sources.model.response.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("current")
    suspend fun getCurrentWeatherData(
        @Query("city") cityName: String,@Query ("key") apiKey : String = API_KEY
    ): WeatherResponse?

    @GET("forecast/daily")
    suspend fun getForecastWeatherData(
        @Query("city") cityName: String, @Query ("key") apiKey : String = API_KEY
    ): ForecastResponse?


}