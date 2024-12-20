package com.example.common.extension

import java.util.concurrent.TimeUnit

/**
 * Converts an integer value (representing duration in seconds) to a string formatted as "MM:SS".
 *
 * This function is typically used to display time durations in a human-readable format.
 *
 * @receiver Int - The duration in seconds.
 * @return String - The formatted duration string in "MM:SS" format.
 *
 * Example Usage:
 * ```kotlin
 * val durationInSeconds = 125
 * val formattedDuration = durationInSeconds.toDurationString() // Output: "02:05"
 * ```
 */
fun Int.toDurationString(): String {
    // Calculate minutes by dividing the total seconds by 60.
    val minutes = this / 60

    // Calculate the remaining seconds using modulus operation.
    val seconds = this % 60

    // Return the formatted string with two digits for both minutes and seconds.
    return "%02d:%02d".format(minutes, seconds)
}

/**
 * Formats an integer value (representing duration in milliseconds) as a string in the format "MM:SS".
 *
 * This function is used to convert durations from milliseconds to a human-readable "MM:SS" format,
 * often for use in audio or video player interfaces.
 *
 * @receiver Int - The duration in milliseconds.
 * @return String - The formatted duration string in "MM:SS" format.
 *
 * Example Usage:
 * ```kotlin
 * val durationInMillis = 125000
 * val formattedDuration = durationInMillis.formatDuration() // Output: "02:05"
 * ```
 */
fun Int.formatDuration(): String {
    // Convert the total milliseconds to minutes.
    val minutes = TimeUnit.MILLISECONDS.toMinutes(this.toLong())

    // Convert the total milliseconds to seconds, then calculate the remaining seconds.
    val seconds = TimeUnit.MILLISECONDS.toSeconds(this.toLong()) % 60

    // Return the formatted string with two digits for both minutes and seconds.
    return String.format("%02d:%02d", minutes, seconds)
}
