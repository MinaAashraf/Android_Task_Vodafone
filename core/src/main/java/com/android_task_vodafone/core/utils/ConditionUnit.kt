package com.android_task_vodafone.core.utils

sealed class ConditionUnit (val name:String){
    object TemperatureUnit : ConditionUnit("C")
    object WindSpeedUnit : ConditionUnit("m/s")
    object PressureUnit : ConditionUnit("mb")
    object HumidityUnit : ConditionUnit("%")
}