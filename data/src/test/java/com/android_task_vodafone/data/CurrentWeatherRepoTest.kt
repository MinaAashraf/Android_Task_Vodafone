package com.android_task_vodafone.data

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.core.utils.generateUrlFromIconCode
import com.android_task_vodafone.data.sources.Mappers.toDomain
import com.android_task_vodafone.data.sources.model.data.CurrentWeatherDTO
import com.android_task_vodafone.data.sources.model.data.WeatherIconWithDescriptionDTO
import com.android_task_vodafone.data.sources.repository.current_weather.CurrentWeatherRepositoryImpl
import com.android_task_vodafone.data.sources.source.remote.current_weather.CurrentWeatherDataSource
import com.android_task_vodafone.features.current_weather.domain.repository.CurrentWeatherRepository
import com.android_task_vodafone.features.current_weather.domain.usecase.GetCurrentWeatherUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CurrentWeatherRepoTest {

    private lateinit var repo: CurrentWeatherRepositoryImpl

    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    @MockK(relaxed = true)
    private lateinit var currentWeatherDataSource: CurrentWeatherDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repo = CurrentWeatherRepositoryImpl(currentWeatherDataSource)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    private val dummyWeatherDto =
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
        coEvery { currentWeatherDataSource.getCurrentWeatherData(dummyCityName) } returns Result.Success(
            dummyWeatherDto
        )
        val resultDomainWeatherInfo = (repo.getCurrentWeather(dummyCityName) as Result.Success).data
        advanceUntilIdle()
        TestCase.assertEquals(dummyWeatherDto.toDomain(), resultDomainWeatherInfo)
        TestCase.assertEquals(dummyWeatherDto.time, resultDomainWeatherInfo.time)
        TestCase.assertEquals(
            dummyWeatherDto.weatherIconWithDescription.iconCode.generateUrlFromIconCode(),
            resultDomainWeatherInfo.iconUrl
        )
    }


    @Test
    fun result_isFailure() = scope.runTest {
        val dummyException = Exception("error")
        coEvery { currentWeatherDataSource.getCurrentWeatherData(dummyCityName) } returns Result.Failure(
            dummyException
        )
        val resultException = (repo.getCurrentWeather(dummyCityName) as Result.Failure).exception
        advanceUntilIdle()
        TestCase.assertEquals(dummyException, resultException)
    }
}