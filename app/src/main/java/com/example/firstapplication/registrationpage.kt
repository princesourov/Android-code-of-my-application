package com.example.firstapplication

import DatabaseHelper
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


        //Data Call findViewById
        username = findViewById(R.id.registerUserName)
        email = findViewById(R.id.email)
        password = findViewById(R.id.registerPassword)
        repassword = findViewById(R.id.reregiPassword)
        registerbutton = findViewById(R.id.registerbutton)
        existinguser = findViewById(R.id.existinguser)


        //register data set
        registerbutton.setOnClickListener(View.OnClickListener {
            val username1 = username.getText().toString()
            val email1 = email.getText().toString()
            val password1 = password.getText().toString()
            val password2 = repassword.getText().toString()
            val db = DatabaseHelper(applicationContext, "LoinHub", null, 1)


            if(username1.length ==0 ||email1.length ==0 ||password1.length ==0 ||password2.length ==0){
                val toast = Toast.makeText(applicationContext, "Please fill all details", Toast.LENGTH_SHORT)
                toast.show()
            }
            else{
                if (password1 !=password2 ){
                    val toast = Toast.makeText(applicationContext, "Confirm password did not match", Toast.LENGTH_SHORT)
                    toast.show()
                    }
                    else{
                        if(isValidPassword(password1)){
                            db.register(username.toString(), email.toString(), password.toString())
                    val toast = Toast.makeText(applicationContext, "Successful registration", Toast.LENGTH_SHORT)
                    toast.show()
                    val Intent = Intent(this,Loginpage::class.java)
                    startActivity(Intent)
                        }

                        else{
                        val toast = Toast.makeText(applicationContext, "Password 8 characters,capital letter, small letter, number and character", Toast.LENGTH_SHORT)
                        toast.show()
                        }
                    }
            }
        })


        //Move Page
        existinguser.setOnClickListener {
            val Intent = Intent(this,Loginpage::class.java)
            startActivity(Intent)
        }
    }


    //Password Type
    internal fun isValidPassword(password: String): Boolean {
        if (password.length < 8) return false
        if (password.filter { it.isDigit() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) return false
        if (password.filter { !it.isLetterOrDigit() }.firstOrNull() == null) return false

        return true
    }
}