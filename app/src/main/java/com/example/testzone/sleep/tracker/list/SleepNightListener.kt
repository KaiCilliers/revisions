package com.example.testzone.sleep.tracker.list

import com.example.testzone.sleep.database.SleepNightEntity

class SleepNightListener(val clickListener: (sleepId: Long) -> Unit) {
    fun onClick(night: SleepNightEntity) = clickListener(night.id)
}