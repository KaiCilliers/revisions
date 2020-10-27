package com.example.testzone.sleep

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testzone.R
import com.example.testzone.databinding.ListItemSleepNightBinding
import com.example.testzone.databinding.ListItemSleepNightGridBinding
import com.example.testzone.sleep.database.SleepNightEntity

class SleepNightAdapter : ListAdapter<SleepNightEntity, SleepNightAdapter.FullViewHolder>(
    SleepNightDifferencesCallBack()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FullViewHolder {
        return FullViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: FullViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class FullViewHolder private constructor(
        val binding: ListItemSleepNightGridBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SleepNightEntity) {
            binding.sleep = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): FullViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemSleepNightGridBinding.inflate(layoutInflater, parent, false)
                return FullViewHolder(binding)
            }
        }
    }
}

class SleepNightDifferencesCallBack : DiffUtil.ItemCallback<SleepNightEntity>() {
    override fun areItemsTheSame(oldItem: SleepNightEntity, newItem: SleepNightEntity): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: SleepNightEntity, newItem: SleepNightEntity): Boolean =
        oldItem == newItem

}