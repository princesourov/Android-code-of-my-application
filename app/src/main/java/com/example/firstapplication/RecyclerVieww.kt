package com.example.firstapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RecyclerVieww : AppCompatActivity() {

    //Variable
    lateinit var RecyclerView : RecyclerView
    var contryName = ArrayList<String>()
    var datalist = ArrayList<String>()
    var imagelist = ArrayList<Int>()
    lateinit var adapter : RecyclerAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        //Data Call
        RecyclerView = findViewById(R.id.Recyclerview)

        //layoutManager
        RecyclerView.layoutManager = LinearLayoutManager(this)

        contryName.add("Spain")
        contryName.add("Pakistan")
        contryName.add("India")

        datalist.add("This is Spainish flag ")
        datalist.add("This is Pakistani flag ")
        datalist.add("This is Indian flag ")

        imagelist.add(R.drawable.spain_flag)
        imagelist.add(R.drawable.pakistan_flag)
        imagelist.add(R.drawable.india_flag)


        adapter = RecyclerAdapter(imagelist,datalist,contryName,this)
        RecyclerView.adapter = adapter

    }
}