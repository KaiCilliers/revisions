package com.example.testzone

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_color_my_views.*

class ColorMyViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_my_views)
        setup()
    }
    private fun setup() {
        val clickableViews = listOf<View>(
            tv_box_one, tv_box_two, tv_box_three, tv_box_four, tv_box_five, constraint_layout
        )
        for(item in clickableViews) {
            item.clickAction { colorView(item) }
        }
    }
    private fun colorView(view: View) = view.setBackgroundColor(
        when (view.id) {
            R.id.tv_box_one -> Color.DKGRAY
            R.id.tv_box_two-> Color.GRAY
            R.id.tv_box_three -> Color.BLUE
            R.id.tv_box_four -> Color.MAGENTA
            R.id.tv_box_five -> Color.BLUE
            else -> Color.LTGRAY
        }
    )
    private fun paintView(view: View) = view.setBackgroundResource(
        when(view.id) {
            R.id.tv_box_one -> R.drawable.dice_1
            R.id.tv_box_two-> R.drawable.dice_2
            R.id.tv_box_three -> R.drawable.dice_3
            R.id.tv_box_four -> R.drawable.dice_4
            R.id.tv_box_five -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    )
}