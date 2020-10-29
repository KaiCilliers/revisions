package com.example.testzone.selection

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testzone.R
import com.example.testzone.clickAction
import com.example.testzone.dessert.DessertActivity
import com.example.testzone.devbyte.DevByteActivity
import com.example.testzone.guess.GuessActivity
import com.example.testzone.mars.MarsActivity
import com.example.testzone.simple.AboutMeActivity
import com.example.testzone.simple.ColorMyViewsActivity
import com.example.testzone.simple.MainActivity
import com.example.testzone.sleep.SleepActivity
import com.example.testzone.trivia.TriviaActivity
import timber.log.Timber

class SelectionAdapter(val action: (Class<*>) -> Unit): RecyclerView.Adapter<SelectionViewHolder>() {
    var data = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(
            R.layout.text_item_view, parent, false
        ) as TextView
        return SelectionViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SelectionViewHolder, position: Int) {
        val item = data[position]
        holder.tv.clickAction {
            action(when(item) {
                "MainActivity" -> MainActivity::class.java
                "AboutMeActivity" -> AboutMeActivity::class.java
                "ColorMyViewsActivity" -> ColorMyViewsActivity::class.java
                "TriviaActivity" -> TriviaActivity::class.java
                "DessertActivity" -> DessertActivity::class.java
                "GuessActivity" -> GuessActivity::class.java
                "SleepActivity" -> SleepActivity::class.java
                "MarsActivity" -> MarsActivity::class.java
                "DevByteActivity" -> DevByteActivity::class.java
                else -> MainActivity::class.java
            })
        }
        holder.tv.text = item
    }
}