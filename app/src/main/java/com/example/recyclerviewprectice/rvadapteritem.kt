package com.example.recyclerviewprectice

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewprectice.rvadapteritem.*
import com.google.android.material.animation.AnimationUtils
import com.google.android.material.card.MaterialCardView

class rvadapteritem(var mlist:List<itemmodel>, private val context:Context):RecyclerView.Adapter<rvadapteritem.Myviewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.userlist, parent, false)

        return Myviewholder(view)

    }

    override fun getItemCount(): Int {
        return mlist.size



    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {

        val itemmodel=mlist[position]
        holder.ivProfile.setImageResource(itemmodel.imageprofile)
        holder.tvUsername.text = itemmodel.username
        holder.tvOnline.text = itemmodel.online
        holder.secondrecyclerView.setHasFixedSize(true)
        holder.secondrecyclerView.layoutManager=LinearLayoutManager(context)
        val adpter=rvsecondadpter(itemmodel.secondlist,context)
        holder.secondrecyclerView.adapter=adpter

        val isexpandable=itemmodel.isExpendable
        holder.secondrecyclerView.visibility=if (isexpandable) View.VISIBLE else View.GONE
        holder.relativeLayout.setOnClickListener(View.OnClickListener {
            itemmodel.isExpendable=!itemmodel.isExpendable
            notifyItemChanged(position)
        })


        if (itemmodel.online=="Online")
        {
            holder.tvOnline.setTextColor(ContextCompat.getColor(context, R.color.green))
        }
        else{
            holder.tvOnline.setTextColor(ContextCompat.getColor(context, R.color.red))

        }




    }

    class Myviewholder (ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val ivProfile:ImageView
        val tvUsername:TextView
        val tvOnline:TextView
        val secondrecyclerView:RecyclerView
        val relativeLayout:RelativeLayout

        init {
             ivProfile = ItemView.findViewById(R.id.Image_profile)
             tvUsername = ItemView.findViewById(R.id.tv_username)
             tvOnline = ItemView.findViewById(R.id.tv_online)
             secondrecyclerView=ItemView.findViewById(R.id.recyclerForsecond)
            relativeLayout=ItemView.findViewById(R.id.relativeForsecondlist)


        }


    }
}