package com.example.testzone.devbyte.ui

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.testzone.R
import com.example.testzone.databinding.DevbyteItemBinding

/**
 * ViewHolder for DevByte items. All work is done by data binding.
 */
class DevByteViewHolder(val viewDataBinding: DevbyteItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.devbyte_item
    }
}