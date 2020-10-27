package com.example.testzone.sleep

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testzone.R
import com.example.testzone.sleep.database.SleepNightEntity

class SleepNightAdapter: RecyclerView.Adapter<SleepNightAdapter.TextItemViewHolder>() {
    var data = listOf<SleepNightEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = "${item.sleepQuality}"
    }

    inner class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
}