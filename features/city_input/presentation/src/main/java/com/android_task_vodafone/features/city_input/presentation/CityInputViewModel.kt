package com.android_task_vodafone.features.city_input.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android_task_vodafone.core.utils.MainDispatcher
import com.android_task_vodafone.features.city_input.domain.usecase.GetCityNameUseCase
import com.android_task_vodafone.features.city_input.domain.usecase.StoreCityNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityInputViewModel @Inject constructor(
    private val storeCityNameUseCase: StoreCityNameUseCase,
    private val getCityNameUseCase: GetCityNameUseCase,
    @MainDispatcher private val dispatcher: CoroutineDispatcher

) : ViewModel() {

    private val _currentCityState: MutableStateFlow<String> = MutableStateFlow("")
    val currentCityState: StateFlow<String> = _currentCityState.asStateFlow()

    private val _firstTimeState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val firstTimeState: StateFlow<Boolean> = _firstTimeState.asStateFlow()

    init {
        viewModelScope.launch(dispatcher) {
            getCityNameUseCase().collect {
                if (it.isNullOrEmpty())
                    _firstTimeState.update { true }
                else {
                    updateCityNameState(it)
                    _firstTimeState.update { false }
                }
            }
        }
    }

    private fun updateCityNameState(cityName: String) {
        _currentCityState.update { (cityName) }
    }

    fun storeCityName(searchQuery: String) {
        viewModelScope.launch(dispatcher) {
            if (searchQuery.isNotEmpty())
                storeCityNameUseCase(searchQuery)
        }
    }
}

