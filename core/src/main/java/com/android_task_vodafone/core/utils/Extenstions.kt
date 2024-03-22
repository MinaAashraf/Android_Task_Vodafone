package com.android_task_vodafone.core.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun String.formatDate(): String {
    val dateValue = LocalDate.parse(this)
    val formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy")
    return formatter.format(dateValue)
}

fun String.generateUrlFromIconCode () = "https://cdn.weatherbit.io/static/img/icons/$this.png"
