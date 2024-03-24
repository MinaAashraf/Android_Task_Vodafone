package com.android_task_vodafone.features.current_weather.domain

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.core.utils.WeatherInfo
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
class GetCurrentWeatherUseCaseTest {

    private lateinit var useCase: GetCurrentWeatherUseCase

    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    @MockK(relaxed = true)
    private lateinit var currentWeatherRepo: CurrentWeatherRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetCurrentWeatherUseCase(currentWeatherRepo)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun result_isSuccessful() = scope.runTest {
        val dummyCityName = "Cairo"
        val dummyWeatherInfoResult = Result.Success(WeatherInfo(temp = 10f))
        coEvery { currentWeatherRepo.getCurrentWeather(dummyCityName) } returns dummyWeatherInfoResult
        val result = useCase(dummyCityName)
        advanceUntilIdle()
        assertEquals(result, dummyWeatherInfoResult)
    }

    @Test
    fun result_isFailure() = scope.runTest {
        val dummyCityName = "invalid name"
        val dummyResult = Result.Failure( Exception("error"))
        coEvery { currentWeatherRepo.getCurrentWeather(dummyCityName) } returns dummyResult
        val result = useCase(dummyCityName)
        advanceUntilIdle()
        assertEquals(result, dummyResult)
    }
}