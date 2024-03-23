package com.android_task_vodafone.features.current_weather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android_task_vodafone.core.utils.MainDispatcher
import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.features.current_weather.domain.usecase.GetCurrentWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    @MainDispatcher private val dispatcher : CoroutineDispatcher

    ) : ViewModel() {

    private val _currentWeatherState: MutableStateFlow<CurrentWeatherState> = MutableStateFlow(CurrentWeatherState())
    val currentWeatherState: StateFlow<CurrentWeatherState> = _currentWeatherState.asStateFlow()

    fun getCurrentWeather(currentCityName : String) {
        _currentWeatherState.update {
            it.copy(
                isLoading = true
            )
        }
        viewModelScope.launch(dispatcher) {
            when (val result = getCurrentWeatherUseCase(currentCityName)) {
                is Result.Success -> _currentWeatherState.update {
                    it.copy(isLoading = false, currentWeather = result.data)
                }
                is Result.Failure -> _currentWeatherState.update {
                    it.copy(isLoading = false, errorMessage = result.exception.message.toString())
                }
            }
        }
    }


}