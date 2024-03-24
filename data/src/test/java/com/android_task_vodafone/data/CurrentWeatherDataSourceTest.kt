package com.android_task_vodafone.data

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.core.utils.generateUrlFromIconCode
import com.android_task_vodafone.data.sources.Mappers.toDomain
import com.android_task_vodafone.data.sources.client_service.WeatherService
import com.android_task_vodafone.data.sources.exceptions.DataNotFoundException
import com.android_task_vodafone.data.sources.model.data.CurrentWeatherDTO
import com.android_task_vodafone.data.sources.model.data.WeatherIconWithDescriptionDTO
import com.android_task_vodafone.data.sources.model.response.WeatherResponse
import com.android_task_vodafone.data.sources.repository.current_weather.CurrentWeatherRepositoryImpl
import com.android_task_vodafone.data.sources.source.remote.current_weather.CurrentWeatherDataSource
import com.android_task_vodafone.data.sources.source.remote.current_weather.CurrentWeatherDataSourceImpl
import com.android_task_vodafone.features.current_weather.domain.repository.CurrentWeatherRepository
import com.android_task_vodafone.features.current_weather.domain.usecase.GetCurrentWeatherUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CurrentWeatherDataSourceTest {

    private lateinit var dataSource: CurrentWeatherDataSource

    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    @MockK(relaxed = true)
    private lateinit var service: WeatherService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dataSource = CurrentWeatherDataSourceImpl(service,dispatcher)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    private val dummyWeatherDto : CurrentWeatherDTO=
        CurrentWeatherDTO(
            temp = 15f,
            humidity = 20f,
            time = "2024-03-23 00:47",
            cityName = "Cairo",
            weatherIconWithDescription = WeatherIconWithDescriptionDTO("c01n", ""),
            windSpeed = 100f,
            pressure = 50f
        )


    private val dummyCityName = "Cairo"

    @Test
    fun result_isSuccessful() = scope.runTest {
        coEvery { service.getCurrentWeatherData(dummyCityName) } returns WeatherResponse(listOf(dummyWeatherDto))
        val resultDomainWeatherDto= dataSource.getCurrentWeatherData(dummyCityName)
        advanceUntilIdle()
        assertEquals(dummyWeatherDto, (resultDomainWeatherDto as Result.Success).data)
    }

    @Test
    fun result_nullResponse() = scope.runTest {
        coEvery { service.getCurrentWeatherData(dummyCityName) } returns null
        val result = dataSource.getCurrentWeatherData(dummyCityName)
        advanceUntilIdle()
        assert (
            result is Result.Failure
        )
        assertEquals (
            (result as Result.Failure).exception.message , DataNotFoundException().message
        )
    }

    @Test
    fun result_nullWeatherDataList() = scope.runTest {
        coEvery { service.getCurrentWeatherData(dummyCityName) } returns WeatherResponse(null)
        val result = dataSource.getCurrentWeatherData(dummyCityName)
        advanceUntilIdle()
        assert (
            result is Result.Failure
        )
        assertEquals (
            (result as Result.Failure).exception.message , DataNotFoundException().message
        )
    }
    @Test
    fun result_emptyWeatherDataList() = scope.runTest {
        coEvery { service.getCurrentWeatherData(dummyCityName) } returns WeatherResponse(emptyList())
        val result = dataSource.getCurrentWeatherData(dummyCityName)
        advanceUntilIdle()
        assert (
            result is Result.Failure
        )
        assertEquals (
            (result as Result.Failure).exception.message , DataNotFoundException().message
        )
    }
}