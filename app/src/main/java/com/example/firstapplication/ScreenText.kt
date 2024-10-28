package com.example.firstapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ScreenText : AppCompatActivity() {
    //Variable
    lateinit var text1 : TextView
    lateinit var button: Button
    lateinit var text2 : TextView
    lateinit var edittext : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_text)

        //Data Call
        text1 = findViewById(R.id.textView4)
        button = findViewById(R.id.showbutton)
        text2 = findViewById(R.id.showtext)
        edittext = findViewById(R.id.editText)



        //Data Set
        text1.setOnClickListener{
            text1.setTextColor(Color.RED)
        }
        button.setOnClickListener{
            var show = edittext.text.toString()
            text2.setText(show)
            val toast = Toast.makeText(this, "Your thoughts are very beautiful ", Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}