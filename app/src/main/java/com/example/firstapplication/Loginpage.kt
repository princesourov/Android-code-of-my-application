package com.example.firstapplication

import DatabaseHelper
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class Loginpage : AppCompatActivity() {
    //OnBackPressedCallback
    var backPressedTime: Long = 0
    //Variable

    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var lodinbutton : Button
    lateinit var newuser : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)

        //OnBackPressedCallback
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            // This function is called automatically when the inbuilt back button is pressed
            override fun handleOnBackPressed() {
                // Checks whether the time elapsed between two consecutive back button presses is less than 3 seconds.
                if (backPressedTime + 3000 > System.currentTimeMillis()) {
                    finish()
                }
                else {
                    Toast.makeText(this@Loginpage, "Press back again to leave the app.", Toast.LENGTH_LONG).show()
                }
                backPressedTime = System.currentTimeMillis()
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)

        //Data Call
        username = findViewById(R.id.LoginUserName)
        password = findViewById(R.id.LoginPassword)
        lodinbutton = findViewById(R.id.loginbutton1)
        newuser = findViewById(R.id.Newuser)


        // Data Set

        //login
        lodinbutton.setOnClickListener(View.OnClickListener {
            val username1 = username.getText().toString()
            val password1 = password.getText().toString()
            val db = DatabaseHelper(applicationContext, "LoinHub", null, 1)
            if(username1.length ==0||password1.length ==0){
                val toast = Toast.makeText(applicationContext, "Please fill all details", Toast.LENGTH_SHORT)
                toast.show()
            }

            else{
                if(db.login(username1,password1)){
                    val toast = Toast.makeText(applicationContext, "Login success", Toast.LENGTH_SHORT)
                    toast.show()
                    val Intent = Intent(this,MainActivity::class.java)
                    Intent.putExtra("name",username1)
                    startActivity(Intent)
                }
                else{
                    val toast = Toast.makeText(applicationContext, "Wrong username and password", Toast.LENGTH_SHORT)
                    toast.show()

                }
            }
        })
        //Move Page
        newuser.setOnClickListener {
            val Intent = Intent(this,registrationpage::class.java)
            startActivity(Intent)
        }
    }
}