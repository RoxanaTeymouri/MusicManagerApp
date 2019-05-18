package ir.android.musicmanager.utils

/**
 * Created by Bassem Samy on 6/17/2017.
 */

object DurationConverter {
    private val SEPARATOR = ":"
    private val DEFAULT_VALUE = "0:0"

    fun getDurationInMinutesText(durationInSeconds: Long): String {
        if (durationInSeconds <= 0) {
            return DEFAULT_VALUE
        }
        val minutes = durationInSeconds / 60
        val seconds = durationInSeconds % 60
        return java.lang.Long.toString(minutes) + SEPARATOR + java.lang.Long.toString(seconds)
    }
}
