package com.android_task_vodafone.weatherlib

import org.junit.Test

class TimeFormattingTest {

    @Test
    fun formattedTime_isCorrectly(){
        val time = "2024-03-24"
        assert("Sunday, March 24, 2024" == WeatherInfoFormatter.formatDate(time))
    }
    @Test
    fun time_isEmpty(){
        val time = ""
        assert("" == WeatherInfoFormatter.formatDate(time))
    }

    @Test
    fun time_notParsedToDate(){
        val time = "2024/03/24"
        assert(time == WeatherInfoFormatter.formatDate(time))
    }

}