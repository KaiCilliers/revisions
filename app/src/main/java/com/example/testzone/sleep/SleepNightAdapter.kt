package com.example.testzone.sleep

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testzone.R
import com.example.testzone.sleep.database.SleepNightEntity
import kotlinx.android.synthetic.main.list_item_sleep_night.view.*

class SleepNightAdapter: RecyclerView.Adapter<SleepNightAdapter.FullViewHolder>() {
    var data = listOf<SleepNightEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FullViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_sleep_night, parent, false)
        return FullViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: FullViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources
        holder.sleepLength.text = convertDurationToFormatted(
            item.startTimeMilli, item.endTimeMilli, res
        )
        holder.quality.text = convertNumericQualityToString(
            item.sleepQuality, res
        )
        holder.qualityImage.setImageResource(when(item.sleepQuality) {
            0 -> R.drawable.ic_sleep_0
            1 -> R.drawable.ic_sleep_1
            2 -> R.drawable.ic_sleep_2
            3 -> R.drawable.ic_sleep_3
            4 -> R.drawable.ic_sleep_4
            5 -> R.drawable.ic_sleep_5
            else -> R.drawable.ic_sleep_active
        })
    }
    inner class FullViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val sleepLength: TextView = itemView.sleep_length
        val quality: TextView = itemView.quality_string
        val qualityImage: ImageView = itemView.quality_image
    }
    inner class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
}