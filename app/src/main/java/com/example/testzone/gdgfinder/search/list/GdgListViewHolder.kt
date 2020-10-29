package com.example.testzone.gdgfinder.search.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testzone.databinding.ListItemGdgBinding
import com.example.testzone.gdgfinder.network.models.GdgChapter

class GdgListViewHolder (private val binding: ListItemGdgBinding):
        RecyclerView.ViewHolder(binding.root) {
    fun bind(listener: GdgClickListener, gdgChapter: GdgChapter) {
        binding.chapter = gdgChapter
        binding.clickListener = listener
        // This is important, because it forces the data binding to execute immediately,
        // which allows the RecyclerView to make the correct view size measurements
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): GdgListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemGdgBinding.inflate(
                layoutInflater, parent, false
            )
            return GdgListViewHolder(binding)
        }
    }
}