package com.example.recyclerviewprectice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdpter(val list:List<viewpagerdata>,context: Context): RecyclerView.Adapter<ViewPagerAdpter.viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdpter.viewholder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.viewpager_layout,parent,false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerAdpter.viewholder, position: Int) {
        val i=list[position]
        holder.imageview.setImageResource(i.imagepager)
        holder.imageview2.setImageResource(i.imagepager2)
        holder.textpager.setText(i.textpager)

    }

    override fun getItemCount(): Int {

        return list.size
    }


    class viewholder(itempager: View):RecyclerView.ViewHolder(itempager) {

        val imageview:ImageView
        val textpager:TextView
        val imageview2:ImageView

        init {
            imageview=itempager.findViewById(R.id.imageViewpager)
            textpager=itempager.findViewById(R.id.tvViewpager)
            imageview2=itempager.findViewById(R.id.imageviewpagercall)

        }

    }


}

