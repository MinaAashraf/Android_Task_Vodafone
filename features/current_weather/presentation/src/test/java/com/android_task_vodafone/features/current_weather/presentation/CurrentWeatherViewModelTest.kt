package com.android_task_vodafone.features.current_weather.presentation

import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.core.utils.WeatherInfo
import com.android_task_vodafone.features.current_weather.domain.repository.CurrentWeatherRepository
import com.android_task_vodafone.features.current_weather.domain.usecase.GetCurrentWeatherUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CurrentWeatherViewModelTest {

    private lateinit var viewModel: CurrentWeatherViewModel

    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    @MockK(relaxed = true)
    private lateinit var getCurrentWeatherUseCase: GetCurrentWeatherUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = CurrentWeatherViewModel(getCurrentWeatherUseCase, dispatcher)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun loadedContentState_isCorrectly() = scope.runTest {
        val mockWeatherInfo = WeatherInfo(temp = 10f)
        coEvery { getCurrentWeatherUseCase(any()) } returns Result.Success(mockWeatherInfo)
        viewModel.getCurrentWeather("ciro")
        advanceUntilIdle()
        //        assertEquals(mockWeatherInfo, viewModel.currentWeatherState.value.currentWeather)
        assert(
            viewModel.currentWeatherState.value ==
                    CurrentWeatherState(currentWeather = mockWeatherInfo)
        )
    }

    @Test
    fun loadedContentState_isFailed() = scope.runTest {
        val mockException = Exception("Data not found")
        coEvery { getCurrentWeatherUseCase(any()) } returns Result.Failure(mockException)
        viewModel.getCurrentWeather("invalid city name")
        advanceUntilIdle()
        assertEquals(mockException.message.toString(), viewModel.currentWeatherState.value.errorMessage)
    }
}