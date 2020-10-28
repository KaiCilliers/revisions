package com.example.testzone.mars.overview.list

import androidx.recyclerview.widget.RecyclerView
import com.example.testzone.databinding.GridViewItemMarsBinding
import com.example.testzone.mars.network.MarsProperty

class MarsPropertyViewHolder(
    private val binding: GridViewItemMarsBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(marsProperty: MarsProperty) {
        binding.property = marsProperty
        binding.executePendingBindings()
    }
}