package com.study.compose.training.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

fun getDateTime(): String {
    val currentTime = LocalDateTime.now()

    val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
    return currentTime.format(formatter)
}