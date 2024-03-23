package com.android_task_vodafone.features.city_input.presentation

import com.android_task_vodafone.features.city_input.domain.usecase.GetCityNameUseCase
import com.android_task_vodafone.features.city_input.domain.usecase.StoreCityNameUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CityInputViewModelTest {

    private lateinit var viewModel: CityInputViewModel

    private val dispatcher = StandardTestDispatcher()
    private val scope = TestScope(dispatcher)

    @MockK(relaxed = true)
    private lateinit var getCityNameUseCase: GetCityNameUseCase

    @MockK(relaxed = true)
    private lateinit var storeCityNameUseCase: StoreCityNameUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel =
            CityInputViewModel(storeCityNameUseCase, getCityNameUseCase, dispatcher)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }


    @Test
    fun getCityNameState_isCorrectly() = scope.runTest {
        val dummyCityName = "Giza"
        coEvery { getCityNameUseCase() } returns flow { emit(dummyCityName) }
        advanceUntilIdle()
        assertEquals(
            dummyCityName,
            viewModel.cityNameState.value
        )
    }

}