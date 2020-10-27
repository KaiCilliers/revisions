package com.example.testzone.sleep.tracker

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.testzone.R
import com.example.testzone.sleep.convertDurationToFormatted
import com.example.testzone.sleep.convertNumericQualityToString
import com.example.testzone.sleep.database.SleepNightEntity

@BindingAdapter("sleepDurationFormatted")
fun TextView.setSleepDurationFormatted(item: SleepNightEntity) {
    text = convertDurationToFormatted(
        item.startTimeMilli, item.endTimeMilli, context.resources
    )
}

@BindingAdapter("sleepQualityString")
fun TextView.setSleepQualityString(item: SleepNightEntity) {
    text = convertNumericQualityToString(
        item.sleepQuality, context.resources
    )
}

@BindingAdapter("sleepImage")
fun ImageView.setSleepImage(item: SleepNightEntity) {
    setImageResource(when (item.sleepQuality) {
        0 -> R.drawable.ic_sleep_0
        1 -> R.drawable.ic_sleep_1
        2 -> R.drawable.ic_sleep_2
        3 -> R.drawable.ic_sleep_3
        4 -> R.drawable.ic_sleep_4
        5 -> R.drawable.ic_sleep_5
        else -> R.drawable.ic_sleep_active
    })
}