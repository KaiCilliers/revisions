package com.example.testzone.simple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.testzone.R
import com.example.testzone.clear
import com.example.testzone.clickAction
import com.example.testzone.gone
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_roll.clickAction { rollDice(img_dice, img_dice_two) }
        btn_count_up.gone()
        btn_reset.clickAction { clear(img_dice, img_dice_two) }
    }
    private fun rollDice(vararg views: ImageView) {
        for(view in views) {
            view.setImageResource(when(randomValue()) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.empty_dice
            })
        }
    }
    private fun randomValue() = (1..6).random()
    private fun clear(vararg views: ImageView) {
        for(view in views) {
            view.clear()
        }
    }

}