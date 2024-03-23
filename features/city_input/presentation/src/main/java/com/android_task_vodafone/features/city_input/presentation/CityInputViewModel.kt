package com.android_task_vodafone.features.city_input.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android_task_vodafone.core.utils.MainDispatcher
import com.android_task_vodafone.features.city_input.domain.usecase.GetCityNameUseCase
import com.android_task_vodafone.features.city_input.domain.usecase.StoreCityNameUseCase
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
class CityInputViewModel @Inject constructor(
    private val storeCityNameUseCase: StoreCityNameUseCase,
    private val getCityNameUseCase: GetCityNameUseCase,
    @MainDispatcher private val dispatcher : CoroutineDispatcher

) : ViewModel() {

    private val _cityNameState: MutableStateFlow<String> = MutableStateFlow("")
    val cityNameState: StateFlow<String> = _cityNameState.asStateFlow()

    init {
        viewModelScope.launch(dispatcher) {
            getCityNameUseCase().collect {
                it?.let { cityName ->
                    if (cityName.isNotEmpty())
                        updateCityNameState(cityName)
                }
            }
        }
    }

    private fun updateCityNameState(cityName: String) {
        _cityNameState.update { (cityName) }
    }

    fun storeCityName(searchQuery : String) {
        viewModelScope.launch(dispatcher) {
            if (searchQuery.isNotEmpty())
                storeCityNameUseCase(searchQuery)
        }
    }
}

