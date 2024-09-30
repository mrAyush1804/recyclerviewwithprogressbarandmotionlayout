package com.example.recyclerviewprectice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class rvadapteritem(
    private var mlist: List<itemmodel>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1
    private var isLoading = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.userlist, parent, false)
            MyViewHolder(view)
        } else {

            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.progressbar, parent, false)
            LoadingViewHolder(view)

        }
    }

    override fun getItemCount(): Int {
        return mlist.size + if (isLoading) 1 else 0
    }

    override fun getItemViewType(position: Int): Int {
        return if (position >= mlist.size) VIEW_TYPE_LOADING else VIEW_TYPE_ITEM
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            populateItemRows(holder, position)
        } else if (holder is LoadingViewHolder) {

           showLoadingView(holder,mlist.size-1)
        }
    }




    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProfile: ImageView = itemView.findViewById(R.id.Image_profile)
        val tvUsername: TextView = itemView.findViewById(R.id.tv_username)
        val tvOnline: TextView = itemView.findViewById(R.id.tv_online)
        val secondRecyclerView: RecyclerView = itemView.findViewById(R.id.recyclerForsecond)
        val relativeLayout: RelativeLayout = itemView.findViewById(R.id.relativeForsecondlist)
    }



    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressbar)
    }


    private class showLoadingView(viewHolder:LoadingViewHolder, position: Int) {

    }


    private fun populateItemRows(viewHolder: MyViewHolder, position: Int) {
        val itemModel = mlist[position]
        viewHolder.ivProfile.setImageResource(itemModel.imageprofile)
        viewHolder.tvUsername.text = itemModel.username
        viewHolder.tvOnline.text = itemModel.online
        viewHolder.secondRecyclerView.setHasFixedSize(true)
        viewHolder.secondRecyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = rvsecondadpter(itemModel.secondlist, context)
        viewHolder.secondRecyclerView.adapter = adapter

        val isExpandable = itemModel.isExpendable
        viewHolder.secondRecyclerView.visibility = if (isExpandable) View.VISIBLE else View.GONE

        viewHolder.relativeLayout.setOnClickListener {
            itemModel.isExpendable = !itemModel.isExpendable
            notifyItemChanged(position)
        }

        viewHolder.tvOnline.setTextColor(
            ContextCompat.getColor(context, if (itemModel.online == "Online") R.color.green else R.color.red)
        )
    }


}
