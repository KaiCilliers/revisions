package com.example.testzone.sleep.tracker.list

import androidx.recyclerview.widget.DiffUtil
import com.example.testzone.sleep.database.SleepNightEntity

class SleepNightDifferencesCallBack : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean =
        oldItem == newItem

}