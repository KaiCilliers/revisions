package com.example.testzone.gdgfinder.search.list

import androidx.recyclerview.widget.DiffUtil
import com.example.testzone.gdgfinder.network.models.GdgChapter

class GdgDifferenceCallback  : DiffUtil.ItemCallback<GdgChapter>() {
    override fun areItemsTheSame(oldItem: GdgChapter, newItem: GdgChapter): Boolean =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: GdgChapter, newItem: GdgChapter): Boolean =
        oldItem == newItem
}