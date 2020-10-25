package com.example.testzone.simple

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.testzone.R
import com.example.testzone.clickAction
import kotlinx.android.synthetic.main.activity_color_my_views.*

class ColorMyViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_my_views)
        setup()
    }
    private fun setup() {
        val clickableViews = listOf<View>(
            tv_box_one, tv_box_two, tv_box_three, tv_box_four, tv_box_five,
            btn_red, btn_green, btn_yellow,
            constraint_layout
        )
        for(item in clickableViews) {
            item.clickAction { colorView(item) }
        }
    }
    private fun colorView(view: View) = when (view.id) {
            R.id.tv_box_one -> view.setBackgroundColor(Color.DKGRAY)
            R.id.tv_box_two -> view.setBackgroundColor(Color.GRAY)
            R.id.tv_box_three -> view.setBackgroundColor(Color.BLUE)
            R.id.tv_box_four -> view.setBackgroundColor(Color.MAGENTA)
            R.id.tv_box_five -> view.setBackgroundColor(Color.BLUE)
            R.id.btn_red -> view.setBackgroundResource(
                R.color.my_red
            )
            R.id.btn_yellow -> view.setBackgroundResource(
                R.color.my_yellow
            )
            R.id.btn_green -> view.setBackgroundResource(
                R.color.my_green
            )
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    private fun paintView(view: View) = view.setBackgroundResource(
        when(view.id) {
            R.id.tv_box_one -> R.drawable.dice_1
            R.id.tv_box_two -> R.drawable.dice_2
            R.id.tv_box_three -> R.drawable.dice_3
            R.id.tv_box_four -> R.drawable.dice_4
            R.id.tv_box_five -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    )
}