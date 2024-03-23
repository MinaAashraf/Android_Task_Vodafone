package com.android_task_vodafone.core.utils

import kotlin.Unit

sealed class ConditionType (val name : String){
    object Temperature : ConditionType("Temperature")
    object WindSpeed : ConditionType("Wind")
    object Pressure : ConditionType("Pressure")
    object Humidity : ConditionType("Humidity")
}


