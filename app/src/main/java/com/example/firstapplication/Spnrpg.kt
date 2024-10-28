package com.example.firstapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class Spnrpg : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    //Variable
    lateinit var layer1 : ConstraintLayout
    //TextView
    lateinit var spinnertext : TextView
    lateinit var tnxtx : TextView
    lateinit var Cuntx : TextView
    lateinit var viewtx : TextView
    //Spinner
    lateinit var spinner : Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spnrpg)

        //Data Call
        layer1 = findViewById(R.id.main)
        //TextView
        spinnertext = findViewById(R.id.spntx)
        tnxtx = findViewById(R.id.tnxtx)
        Cuntx = findViewById(R.id.Cuntx)
        viewtx = findViewById(R.id.viewtx)



        //Spinner
        spinner = findViewById(R.id.counreyname)

        spinner.onItemSelectedListener = this


        //Adapter
        var Adapter = ArrayAdapter.createFromResource(this, R.array.country_name, android.R.layout.simple_spinner_item )


        //Set Adapter
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //pass Adapter
        spinner.adapter = Adapter


        // Data Set
        spinnertext.setOnClickListener{
            spinnertext.setTextColor(Color.RED)
        }
        tnxtx.setOnClickListener{
            tnxtx.setTextColor(Color.GREEN)
        }
        Cuntx.setOnClickListener{
            Snackbar.make(layer1,"South Asian Association for Regional Co-operation", Snackbar.LENGTH_INDEFINITE,)
                .setAction("Close",View.OnClickListener {  }).show()
        }



    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewtx.text = parent!!.getItemAtPosition(position).toString()
        Toast.makeText(this," "+parent!!.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}