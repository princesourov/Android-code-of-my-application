package com.example.firstapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerAdapter(
    var imagelist: ArrayList<Int>,
    var datalist: ArrayList<String>,
    var contryName: ArrayList<String>,
    var context: Context) : RecyclerView.Adapter<RecyclerAdapter.countryViewHolder>()
{
    class countryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<CircleImageView>(R.id.profile_image)
        val contryNameview = itemView.findViewById<TextView>(R.id.textView8)
        val datalistView = itemView.findViewById<TextView>(R.id.textView9)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): countryViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_card,parent,false)
        return countryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contryName.size
    }

    override fun onBindViewHolder(holder: countryViewHolder, position: Int) {
        holder.imageView.setImageResource(imagelist.get(position))
        holder.contryNameview.text = contryName.get(position)
        holder.datalistView.text = datalist.get(position)
    }


}