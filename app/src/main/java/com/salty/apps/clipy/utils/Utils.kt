package com.salty.apps.clipy.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {
    fun convertToKorM(input: Long): String {
        return when {
            input >= 1_000_000 -> {
                val result = input / 1_000_000.0
                if (result % 1 == 0.0)
                    "${result.toInt()}M"
                else
                    String.format(Locale.getDefault(), "%.1fM", result)
            }

            input >= 1000 -> {
                val result = input / 1000.0
                if (result % 1 == 0.0)
                    "${result.toInt()}K"
                else
                    String.format(Locale.getDefault(), "%.1fK", result)
            }

            else -> "$input"
        }
    }

    fun convertSecondsToMinutes(seconds: Long): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60

        return String.format(locale = Locale.getDefault(), "%02d:%02d", minutes, remainingSeconds)
    }

    fun convertToDate(isoDate: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
        val date: Date =
            inputFormat.parse(isoDate) ?: throw IllegalArgumentException("Invalid date format")
        val outputFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

        return outputFormat.format(date)
    }

}