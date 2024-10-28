package com.example.firstapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class ScreenColor : AppCompatActivity() {
    //Variable
    lateinit var layout : ConstraintLayout
    lateinit var green : RadioButton
    lateinit var red : RadioButton
    lateinit var blue : RadioButton
    lateinit var text : TextView
    lateinit var buttoncolor : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_color)

        //Data Call
        layout = findViewById(R.id.main)
        green = findViewById(R.id.green)
        red = findViewById(R.id.red)
        blue = findViewById(R.id.blue)
        buttoncolor = findViewById(R.id.button)

        // Data Cng Input
        buttoncolor.setOnClickListener {
            if (green.isChecked) {
                layout.setBackgroundColor(Color.GREEN)
                green.setTextColor(Color.RED)
                red.setTextColor(Color.RED)
                blue.setTextColor(Color.RED)
                val toast = Toast.makeText(this, "All Screen Green Now ", Toast.LENGTH_SHORT)
                toast.show()

            } else if (red.isChecked) {
                layout.setBackgroundColor(Color.RED)
                green.setTextColor(Color.GREEN)
                red.setTextColor(Color.GREEN)
                blue.setTextColor(Color.GREEN)
                val toast = Toast.makeText(this, "All Screen Red Now ", Toast.LENGTH_SHORT)
                toast.show()

            } else if (blue.isChecked) {
                layout.setBackgroundColor(Color.BLUE)
                green.setTextColor(Color.WHITE)
                red.setTextColor(Color.WHITE)
                blue.setTextColor(Color.WHITE)
                val toast = Toast.makeText(this, "All Screen Blue Now ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
    }
}