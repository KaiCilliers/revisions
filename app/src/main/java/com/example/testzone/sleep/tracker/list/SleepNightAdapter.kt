package com.example.testzone.sleep.tracker.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testzone.databinding.ListItemSleepNightGridBinding
import com.example.testzone.sleep.database.SleepNightEntity
import java.lang.ClassCastException

private val ITEM_VIEW_TYPE_HEADER = 0
private val ITEM_VIEW_TYPE_ITEM = 1

class SleepNightAdapter(val clickListener: SleepNightListener):
    ListAdapter<DataItem, RecyclerView.ViewHolder>(
    SleepNightDifferencesCallBack()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> HeaderViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> FullViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    fun addHeaderAndSubmitList(list: List<SleepNightEntity>) {
        val items = when (list.size) {
            0 -> listOf(DataItem.Header)
            else -> listOf(DataItem.Header) + list.map { DataItem.SleepNightItem(it) }
        }
        submitList(items)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is FullViewHolder -> {
                holder.bind(
                    (getItem(position) as DataItem.SleepNightItem).sleepNight,
                    clickListener
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.SleepNightItem -> ITEM_VIEW_TYPE_ITEM
            else -> -1
        }
    }

    class FullViewHolder private constructor(
        val binding: ListItemSleepNightGridBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: SleepNightEntity,
            clickListener: SleepNightListener
        ) {
            binding.sleep = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): FullViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemSleepNightGridBinding.inflate(layoutInflater, parent, false)
                return FullViewHolder(
                    binding
                )
            }
        }
    }
}

