package com.android_task_vodafone.features.forecast.domain

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.features.forecast.domain.repository.ForecastRepository
import com.android_task_vodafone.features.forecast.domain.usecase.GetForecastUseCase
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
class GetForecastUseCaseTest {

    private lateinit var useCase: GetForecastUseCase

    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    @MockK(relaxed = true)
    private lateinit var forecastRepo: ForecastRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetForecastUseCase(forecastRepo)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    private val dummyForecast = listOf<WeatherInfo>(
        WeatherInfo(temp = 10f),
        WeatherInfo(temp = 15f)
    )
    @Test
    fun result_isSuccessful() = scope.runTest {
        val dummyCityName = "Cairo"
        val dummyResult =  Result.Success(dummyForecast)
        coEvery { forecastRepo.getForecast(dummyCityName) } returns dummyResult
        val result = useCase(dummyCityName)
        advanceUntilIdle()
        TestCase.assertEquals(dummyResult, result)
    }

    @Test
    fun result_isFailure() = scope.runTest {
        val dummyCityName = "invalid name"
        val dummyResult = Result.Failure( Exception("error"))
        coEvery { forecastRepo.getForecast(dummyCityName) } returns dummyResult
        val result = useCase(dummyCityName)
        advanceUntilIdle()
        TestCase.assertEquals(result, dummyResult)
    }
}