package com.example.testzone.mars.overview.list

import androidx.recyclerview.widget.DiffUtil
import com.example.testzone.mars.network.MarsProperty

class MarsDifferencesCallback : DiffUtil.ItemCallback<MarsProperty>() {
    override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean =
        oldItem.id == newItem.id
}