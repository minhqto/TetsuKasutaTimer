package com.example.tetsukasuta4x6.utils

import java.util.concurrent.TimeUnit

object Utility {

    //45 secs because that's the interval we need
    const val pourInterval = 4500L
    const val rounds = 5
    private const val TIME_FORMAT = "00: %02d"

    //convert time to milli seconds
    fun Long.formatTime(): String = String.format(
        TIME_FORMAT,
        TimeUnit.MILLISECONDS.toMinutes(this),
        TimeUnit.MILLISECONDS.toSeconds(this) % 60
    )

}