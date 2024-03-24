package com.android_task_vodafone.core

import com.android_task_vodafone.core.utils.formatDate
import com.android_task_vodafone.core.utils.generateUrlFromIconCode
import org.junit.Test

class IconUrlGeneratorTest {

    @Test
    fun iconGenerated_isCorrectly() {
        val iconCode = "c01n"
        assert(
            "https://cdn.weatherbit.io/static/img/icons/$iconCode.png"
                    == iconCode.generateUrlFromIconCode()
        )
    }

    @Test
    fun iconGenerated_isNull() {
        val iconCode : String? = null
        assert(
            null == iconCode.generateUrlFromIconCode()
        )
    }

    @Test
    fun iconGenerated_isEmpty() {
        val iconCode  = ""
        assert(
            "" == iconCode.generateUrlFromIconCode()
        )
    }

}