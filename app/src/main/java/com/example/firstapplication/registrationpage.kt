package com.example.firstapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class registrationpage : AppCompatActivity() {

    //Variable
    lateinit var username : EditText
    lateinit var email : EditText
    lateinit var password : EditText
    lateinit var repassword : EditText
    lateinit var registerbutton : Button
    lateinit var existinguser : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrationpage)

        //Data Call
        username = findViewById(R.id.registerUserName)
        email = findViewById(R.id.email)
        password = findViewById(R.id.registerPassword)
        repassword = findViewById(R.id.reregiPassword)
        registerbutton = findViewById(R.id.registerbutton)
        existinguser = findViewById(R.id.existinguser)

        //register
        registerbutton.setOnClickListener(View.OnClickListener {
            val username1 = username.getText().toString()
            val email1 = email.getText().toString()
            val password1 = password.getText().toString()
            val password2 = repassword.getText().toString()
            if(username1.length ==0 ||email1.length ==0 ||password1.length ==0 ||password2.length ==0){
                val toast = Toast.makeText(applicationContext, "Please fill all details", Toast.LENGTH_SHORT)
                toast.show()
            }

            else{
                if (password1 !=password2 ){
                    val toast = Toast.makeText(applicationContext, "Confirm password did not match", Toast.LENGTH_SHORT)
                    toast.show()
                }
                else{ val toast = Toast.makeText(applicationContext, "Successful registration", Toast.LENGTH_SHORT)
                toast.show()
                    val Intent = Intent(this,Loginpage::class.java)
                    startActivity(Intent)
                }
            }

        })


        //Move Page
        existinguser.setOnClickListener {
            val Intent = Intent(this,Loginpage::class.java)
            startActivity(Intent)
        }

    }
}