package com.android_task_vodafone.features.forecast.presentation

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.features.forecast.domain.usecase.GetForecastUseCase
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
class ForecastViewModelTest {

    private lateinit var viewModel: ForecastViewModel

    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    @MockK(relaxed = true)
    private lateinit var getForecastUseCase: GetForecastUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = ForecastViewModel(getForecastUseCase, dispatcher)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    private val dummyForecast = listOf(
        WeatherInfo(temp = 15f),
        WeatherInfo(temp = 15f),
        WeatherInfo(temp = 15f)
    )

    @Test
    fun loadedContentState_isCorrectly() = scope.runTest {
        coEvery { getForecastUseCase(any()) } returns Result.Success(dummyForecast)
        viewModel.onEvent(ForecastEvent.OnRefresh("cairo"))
        advanceUntilIdle()
        assertEquals(
            viewModel.forecastUiState.value, ForecastUiState(forecast = dummyForecast)
        )
    }

    @Test
    fun loadedContentState_isFailed() = scope.runTest {
        val mockException = Exception("Data not found")
        coEvery { getForecastUseCase(any()) } returns Result.Failure(mockException)
        viewModel.onEvent(ForecastEvent.OnRefresh(""))
        advanceUntilIdle()
        assertEquals(
            mockException.message.toString(), viewModel.forecastUiState.value.errorMessage
        )
    }
}