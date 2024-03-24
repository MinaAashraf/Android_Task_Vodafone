package com.android_task_vodafone.weatherlib

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object WeatherInfoFormatter {
        fun formatDate(time: String): String {
            return try {
                val dateValue = LocalDate.parse(time)
                val formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy")
                formatter.format(dateValue)
            } catch (e: Exception) {
                time
            }

        }

        fun formatIconUrl(iconCode: String?) =
            if (!iconCode.isNullOrEmpty())
                "https://cdn.weatherbit.io/static/img/icons/$iconCode.png"
            else iconCode
    }


