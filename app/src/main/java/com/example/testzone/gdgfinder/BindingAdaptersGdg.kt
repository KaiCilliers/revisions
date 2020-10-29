package com.example.testzone.gdgfinder

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testzone.gdgfinder.network.models.GdgChapter
import com.example.testzone.gdgfinder.search.list.GdgListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(rc: RecyclerView, data: List<GdgChapter>?) {
    val adapter = rc.adapter as GdgListAdapter
    adapter.submitList(data) {
        // scroll the list to the top after the diffs are calculated and posted
        rc.scrollToPosition(0)
    }
}

@BindingAdapter("showOnlyWhenEmpty")
fun View.showOnlyWhenEmpty(data: List<Any>) {
    visibility = when {
        data == null || data.isEmpty() -> View.VISIBLE
        else -> View.GONE
    }
}