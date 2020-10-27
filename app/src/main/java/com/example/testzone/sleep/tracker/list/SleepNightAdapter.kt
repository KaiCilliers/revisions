package com.example.testzone.sleep.tracker.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testzone.databinding.ListItemSleepNightGridBinding
import com.example.testzone.sleep.database.SleepNightEntity

class SleepNightAdapter(val clickListener: SleepNightListener):
    ListAdapter<SleepNightEntity, SleepNightAdapter.FullViewHolder>(
    SleepNightDifferencesCallBack()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FullViewHolder {
        return FullViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: FullViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
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

