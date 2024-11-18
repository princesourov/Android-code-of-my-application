package com.example.firstapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.app.AlertDialog
import android.view.View
import kotlin.system.exitProcess
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    //OnBackPressedCallback
    var backPressedTime: Long = 0

    //Variable
    lateinit var layer0 : ConstraintLayout
    //Text View
    lateinit var welcomeX : TextView
    lateinit var welcomeY : TextView
    lateinit var welcomeA : TextView
    lateinit var welcomeB : TextView
    lateinit var welcomeC : TextView
    lateinit var welcomeD : TextView
    lateinit var welcomeE : TextView
    lateinit var welcomeF : TextView
    lateinit var welcomeG : TextView
    lateinit var usernameshow : TextView

    //Buttom
    lateinit var MoveBatton : Button
    lateinit var MoveBatton2 : Button
    lateinit var MoveBatton3 : Button
    lateinit var MoveBatton4 : Button
    lateinit var MoveBatton5 : Button
    lateinit var MoveBatton6 : Button
    lateinit var logoutButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //OnBackPressedCallback
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            // This function is called automatically when the inbuilt back button is pressed
            override fun handleOnBackPressed() {
                // Checks whether the time elapsed between two consecutive back button presses is less than 3 seconds.
                if (backPressedTime + 3000 > System.currentTimeMillis()) {
                    finish()
                }
                else {
                    Toast.makeText(this@MainActivity, "Press back again to leave the app.", Toast.LENGTH_LONG).show()
                }
                backPressedTime = System.currentTimeMillis()
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)


        //Data Call

        layer0 = findViewById(R.id.main)

        //Text View
        welcomeX = findViewById(R.id.welcome)
        welcomeY = findViewById(R.id.welcomeB)
        welcomeA = findViewById(R.id.screencolor)
        welcomeB = findViewById(R.id.screenpicture)
        welcomeC = findViewById(R.id.textView3)
        welcomeD = findViewById(R.id.spinText)
        welcomeE = findViewById(R.id.textView6)
        welcomeF = findViewById(R.id.textView7)
        welcomeG = findViewById(R.id.mywork)
        usernameshow = findViewById(R.id.usernameshow)

        //Buttom
        MoveBatton = findViewById(R.id.gobutton)
        MoveBatton2 = findViewById(R.id.gobutton2)
        MoveBatton3 = findViewById(R.id.gobutton3)
        MoveBatton4 = findViewById(R.id.gobutton4)
        MoveBatton5 = findViewById(R.id.gobutton5)
        MoveBatton6 = findViewById(R.id.gobutton6)
        logoutButton = findViewById(R.id.logoutbutton)

        // Data Set
        //usernameshow data set
        var usernameshowv :String = intent.getStringExtra("name").toString()
        usernameshow.text = "$usernameshowv"


        //back button
        // When button is clicked, ALertDialog
        // is created and displayed
        logoutButton.setOnClickListener {
            val mBuilder = AlertDialog.Builder(this)
                .setTitle("Log out?")
                .setMessage("Are you sure you want to log out?")
                .setPositiveButton("LOG OUT", null)
                .setNegativeButton("CANCEL", null)
                .show()

            // Function for the positive button
            // is programmed to exit the application
            val mPositiveButton = mBuilder.getButton(AlertDialog.BUTTON_POSITIVE)
            mPositiveButton.setOnClickListener {
                exitProcess(0)
            }
        }


        // Data Set
        //This Page
        welcomeA.setOnClickListener{
            welcomeA.setTextColor(Color.RED)
        }
        welcomeB.setOnClickListener{
            welcomeB.setTextColor(Color.RED)
        }
        welcomeC.setOnClickListener{
            welcomeC.setTextColor(Color.RED)
        }
        welcomeX.setOnClickListener{
            welcomeX.setTextColor(Color.RED)
            val toast = Toast.makeText(this, "Welcome to our Project", Toast.LENGTH_SHORT)
            toast.show()
        }
        welcomeD.setOnClickListener{
            welcomeD.setTextColor(Color.RED)
        }
        welcomeE.setOnClickListener{
            welcomeE.setTextColor(Color.RED)
        }
        welcomeF.setOnClickListener{
            welcomeF.setTextColor(Color.RED)
        }
        welcomeY.setOnClickListener{
            welcomeY.setText("Thank You")
            welcomeY.setTextColor(Color.GREEN)
        }
        welcomeG.setOnClickListener{
            Snackbar.make(layer0,"Everything taught by Himel sir will be practiced and saved through these apps", Snackbar.LENGTH_INDEFINITE,)
                .setAction("Close", View.OnClickListener {  }).show()
        }



        //Move Page
        MoveBatton.setOnClickListener {
            val Intent = Intent(this,ScreenColor::class.java)
            startActivity(Intent)
        }
        MoveBatton2.setOnClickListener {
            val Intent = Intent(this,ScreenPicture::class.java)
            startActivity(Intent)
        }
        MoveBatton3.setOnClickListener {
            val Intent = Intent(this,ScreenText::class.java)
            startActivity(Intent)
        }
        MoveBatton4.setOnClickListener {
            val Intent = Intent(this,Spnrpg::class.java)
            startActivity(Intent)
        }
        MoveBatton5.setOnClickListener {
            val Intent = Intent(this,spnrwtpc::class.java)
            startActivity(Intent)
        }
        MoveBatton6.setOnClickListener {
            val Intent = Intent(this,RecyclerVieww::class.java)
            startActivity(Intent)
        }


    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
    override fun onDestroy() {
        super.onDestroy()
    }
    override fun onRestart() {
        super.onRestart()
    }
    override fun onPause() {
        super.onPause()
    }
    override fun onStop() {
        super.onStop()
    }
}