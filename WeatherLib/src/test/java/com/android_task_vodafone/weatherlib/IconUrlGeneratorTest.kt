package com.android_task_vodafone.weatherlib

import org.junit.Test

class IconUrlGeneratorTest {

    @Test
    fun iconGenerated_isCorrectly() {
        val iconCode = "c01n"
        assert(
            "https://cdn.weatherbit.io/static/img/icons/$iconCode.png"
                    == WeatherInfoFormatter.formatIconUrl(iconCode)
        )
    }

    @Test
    fun iconGenerated_isNull() {
        val iconCode : String? = null
        assert(
            null  == WeatherInfoFormatter.formatIconUrl(iconCode)

        )
    }

    @Test
    fun iconGenerated_isEmpty() {
        val iconCode  = ""
        assert(
            "" == WeatherInfoFormatter.formatIconUrl(iconCode)

        )
    }

}