package com.android_task_vodafone.data

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.data.sources.client_service.WeatherService
import com.android_task_vodafone.data.sources.exceptions.DataNotFoundException
import com.android_task_vodafone.data.sources.model.data.DailyForecastDTO
import com.android_task_vodafone.data.sources.model.data.WeatherIconWithDescriptionDTO
import com.android_task_vodafone.data.sources.model.response.ForecastResponse
import com.android_task_vodafone.data.sources.source.remote.forecast.ForecastDataSource
import com.android_task_vodafone.data.sources.source.remote.forecast.ForecastDataSourceImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
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
class ForecastDataSourceTest {

    private lateinit var dataSource: ForecastDataSource

    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    @MockK(relaxed = true)
    private lateinit var service: WeatherService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dataSource = ForecastDataSourceImpl(service, dispatcher)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }


    private val dummyForecastDTO: DailyForecastDTO = DailyForecastDTO(
        temp = 15f,
        humidity = 20f,
        time = "2024-03-23 00:47",
        weatherIconWithDescription = WeatherIconWithDescriptionDTO("c01n", ""),
        windSpeed = 100f,
        pressure = 50f
    )
    private val dummyForecastList = listOf(dummyForecastDTO, dummyForecastDTO)
    private val dummyCityName = "Cairo"

    @Test
    fun result_isSuccessful() = scope.runTest {
        coEvery { service.getForecastWeatherData(dummyCityName) } returns ForecastResponse(dummyForecastList)
        val resultForecast = dataSource.getForecast(dummyCityName)
        advanceUntilIdle()
        assertEquals(dummyForecastList, (resultForecast as Result.Success).data)
    }

    @Test
    fun result_nullResponse() = scope.runTest {
        coEvery { service.getForecastWeatherData(dummyCityName) } returns null
        val result = dataSource.getForecast(dummyCityName)
        advanceUntilIdle()
        assert(
            result is Result.Failure
        )
        assertEquals(
            (result as Result.Failure).exception.message, DataNotFoundException().message
        )
    }

    @Test
    fun result_nullForecastList() = scope.runTest {
        coEvery { service.getForecastWeatherData(dummyCityName) } returns ForecastResponse(null)
        val result = dataSource.getForecast(dummyCityName)
        advanceUntilIdle()
        assert(
            result is Result.Failure
        )
        assertEquals(
            (result as Result.Failure).exception.message, DataNotFoundException().message
        )
    }

    @Test
    fun result_emptyWeatherDataList() = scope.runTest {
        coEvery { service.getForecastWeatherData(dummyCityName) } returns ForecastResponse(emptyList())
        val result = dataSource.getForecast(dummyCityName)
        advanceUntilIdle()
        assert(
            result is Result.Failure
        )
        assertEquals(
            (result as Result.Failure).exception.message, DataNotFoundException().message
        )
    }
}