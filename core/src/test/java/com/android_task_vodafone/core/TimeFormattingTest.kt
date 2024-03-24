package com.android_task_vodafone.core

import com.android_task_vodafone.core.utils.formatDate
import org.junit.Test
class TimeFormattingTest {

    @Test
    fun formattedTime_isCorrectly(){
        val time = "2024-03-24"
        assert("Sunday, March 24, 2024" == time.formatDate())
    }
    @Test
    fun time_isEmpty(){
        val time = ""
        assert("" == time.formatDate())
    }

    @Test
    fun time_notParsedToDate(){
        val time = "2024/03/24"
        assert(time == time.formatDate())
    }

}