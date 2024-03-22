package com.android_task_vodafone.features.city_input.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android_task_vodafone.features.city_input.domain.usecase.StoreCityNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityInputViewModel @Inject constructor(private val storeCityNameUseCase: StoreCityNameUseCase) :
    ViewModel() {

    private val _cityNameState: MutableStateFlow<String> = MutableStateFlow("")
    val cityNameState: StateFlow<String> = _cityNameState.asStateFlow()

    fun storeCityName(cityName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            storeCityNameUseCase(cityName)
        }
    }

}