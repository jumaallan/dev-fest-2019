package com.androidstudy.weather.ui.views.utils

import java.text.SimpleDateFormat
import java.util.*

fun Long.toDate(pattern: String): String {
    val date = Date(this * 1000)
    val formatter = SimpleDateFormat(pattern)
    return formatter.format(date)
}

fun Int.toDate(pattern: String): String {
    val date = Date((this * 1000).toLong())
    val formatter = SimpleDateFormat(pattern)
    return formatter.format(date)
}