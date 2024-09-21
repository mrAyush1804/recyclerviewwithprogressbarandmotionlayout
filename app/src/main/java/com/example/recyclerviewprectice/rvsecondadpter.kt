package com.example.recyclerviewprectice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class rvsecondadpter(var msecondList: List<secondlist>,val context: Context): RecyclerView.Adapter<rvsecondadpter.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvsecondadpter.viewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.seconduserlist,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: rvsecondadpter.viewHolder, position: Int) {
        val itemm=msecondList[position]
        holder.textView1.text=itemm.group
        holder.textView2.text=itemm.call
        holder.textView3.text=itemm.normal
        holder.imageView1.setImageResource(itemm.immage1)
        holder.imageView2.setImageResource(itemm.immage2)
        holder.imageView3.setImageResource(itemm.immage3)
    }

    override fun getItemCount(): Int {
       return msecondList.size
    }

    class viewHolder(secondlistitem: View): RecyclerView.ViewHolder(secondlistitem)
    {
        val textView1:TextView
        val textView2:TextView
        val textView3:TextView
        val imageView1:ImageView
        val imageView2:ImageView
        val imageView3:ImageView



        init {
            textView1=secondlistitem.findViewById(R.id.text_groupcall)
            textView2=secondlistitem.findViewById(R.id.text_videocall)
            textView3=secondlistitem.findViewById(R.id.text_noramlcall)
            imageView1=secondlistitem.findViewById(R.id.iv_group)
            imageView2=secondlistitem.findViewById(R.id.iv_Video)
            imageView3=secondlistitem.findViewById(R.id.iv_noramlcall)
        }

    }

}
