package com.android_task_vodafone.core.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun String.formatDate(): String {
  return  try {
        val dateValue = LocalDate.parse(this)
        val formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy")
      formatter.format(dateValue)
    }catch (e:Exception){
        this
    }

}

fun String.generateUrlFromIconCode() = "https://cdn.weatherbit.io/static/img/icons/$this.png"
