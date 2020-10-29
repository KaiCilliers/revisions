package com.example.testzone.gdgfinder.search.list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testzone.gdgfinder.network.models.GdgChapter

class GdgListAdapter(val clickListener: GdgClickListener) : ListAdapter<GdgChapter, GdgListViewHolder>(GdgDifferenceCallback()) {
    /**
     * Part of the RecyclerView adapter, called when RecyclerView needs a new [ViewHolder].
     *
     * A ViewHolder holds a view for the [RecyclerView] as well as providing additional information
     * to the RecyclerView such as where on the screen it was last drawn during scrolling.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GdgListViewHolder {
        return GdgListViewHolder.from(parent)

    }

    /**
     * Part of the RecyclerView adapter, called when RecyclerView needs to show an item.
     *
     * The ViewHolder passed may be recycled, so make sure that this sets any properties that
     * may have been set previously.
     */
    override fun onBindViewHolder(holder: GdgListViewHolder, position: Int) {
        holder.bind(clickListener, getItem(position))
    }
}