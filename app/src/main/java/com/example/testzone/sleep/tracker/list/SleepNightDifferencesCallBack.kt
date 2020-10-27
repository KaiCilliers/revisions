package com.example.testzone.sleep.tracker.list

import androidx.recyclerview.widget.DiffUtil
import com.example.testzone.sleep.database.SleepNightEntity

class SleepNightDifferencesCallBack : DiffUtil.ItemCallback<SleepNightEntity>() {
    override fun areItemsTheSame(oldItem: SleepNightEntity, newItem: SleepNightEntity): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: SleepNightEntity, newItem: SleepNightEntity): Boolean =
        oldItem == newItem

}