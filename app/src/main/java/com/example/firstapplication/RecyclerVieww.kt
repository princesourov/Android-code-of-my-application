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
        contryName.add("australia")
        contryName.add("canada")
        contryName.add("brazil")
        contryName.add("china")
        contryName.add("germany")
        contryName.add("italy")
        contryName.add("mexico")
        contryName.add("netherlands")

        datalist.add("This is Spainish flag ")
        datalist.add("This is Pakistani flag ")
        datalist.add("This is Indian flag ")
        datalist.add("This is australian flag ")
        datalist.add("This is canadan flag ")
        datalist.add("This is brazilian flag ")
        datalist.add("This is Chinese flag ")
        datalist.add("This is germany flag ")
        datalist.add("This is Italian flag ")
        datalist.add("This is mexico flag ")
        datalist.add("This is netherlands flag ")

        imagelist.add(R.drawable.spain_flag)
        imagelist.add(R.drawable.pakistan_flag)
        imagelist.add(R.drawable.india_flag)
        imagelist.add(R.drawable.australia_flag)
        imagelist.add(R.drawable.canada_flag)
        imagelist.add(R.drawable.brazil_flag)
        imagelist.add(R.drawable.china_flag)
        imagelist.add(R.drawable.germany_flag)
        imagelist.add(R.drawable.italy_flag)
        imagelist.add(R.drawable.mexico_flag)
        imagelist.add(R.drawable.netherlands_flag)


        adapter = RecyclerAdapter(imagelist,datalist,contryName,this)
        RecyclerView.adapter = adapter

    }
}