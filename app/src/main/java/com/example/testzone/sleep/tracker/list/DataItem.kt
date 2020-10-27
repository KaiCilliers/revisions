package com.example.testzone.sleep.tracker.list

import com.example.testzone.sleep.database.SleepNightEntity

sealed class DataItem {
    abstract val id: Long
    data class SleepNightItem(val sleepNight: SleepNightEntity): DataItem() {
        override val id = sleepNight.id
    }
    object Header: DataItem() {
        override val id = Long.MIN_VALUE
    }
}