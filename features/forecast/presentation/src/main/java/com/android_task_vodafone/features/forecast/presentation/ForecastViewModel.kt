package com.android_task_vodafone.features.forecast.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android_task_vodafone.core.utils.Result
import com.android_task_vodafone.features.forecast.domain.usecase.GetForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val getForecastUseCase: GetForecastUseCase): ViewModel() {



    private val _forecastUiState: MutableStateFlow<ForecastUiState> = MutableStateFlow(ForecastUiState())
    val forecastUiState: StateFlow<ForecastUiState> = _forecastUiState.asStateFlow()

    init {
        getForecast()
    }

    private fun getForecast() {
        _forecastUiState.update {
            it.copy(
                isLoading = true
            )
        }
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getForecastUseCase("Cairo")) {
                is Result.Success -> _forecastUiState.update {
                    it.copy(isLoading = false, forecast = result.data)
                }
                is Result.Failure -> _forecastUiState.update {
                    it.copy(isLoading = false, errorMessage = result.exception.toString())
                }
            }
        }
    }


}