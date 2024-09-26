package com.example.recyclerviewprectice

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var secondrecyclerview:RecyclerView
    private lateinit var materialCardView: MaterialCardView
    private lateinit var rvadapteritem: rvadapteritem
    private lateinit var dataList: ArrayList<itemmodel>
    val data = ArrayList<itemmodel>()
    private lateinit var   info:ArrayList<secondlist>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black);
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        insalization()
        recyclerView.layoutManager = LinearLayoutManager(this)


        val info = ArrayList<secondlist>()
        info.add(
            secondlist(
                R.drawable.videocall,
                R.drawable.group_video_call,
                R.drawable.incoming_call,
                "Group call",
                "Video Call",
                "call"
            ),
        )
        val info1 = ArrayList<secondlist>()
        info1.add(
            secondlist(
                R.drawable.videocall,
                R.drawable.group_video_call,
                R.drawable.no_internet_connection,
                "Group call",
                "Video Call",
                "Network"
            ),
        )




        data.add(itemmodel(R.drawable.male, "Username", "Online", info))
        data.add(itemmodel(R.drawable.girl, "Username", "Offline", info1))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online", info))
        data.add(itemmodel(R.drawable.male, "Username", "Online", info))
        data.add(itemmodel(R.drawable.girl, "Username", "Offline", info1))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online", info))
        data.add(itemmodel(R.drawable.girl, "Username", "Online", info))
        data.add(itemmodel(R.drawable.doctor, "Username", "Offline", info1))
        data.add(itemmodel(R.drawable.male__1_, "Username", "Online", info))
        data.add(itemmodel(R.drawable.male, "Username", "Online", info))
        data.add(itemmodel(R.drawable.doctor, "Username", "Offline", info1))
        data.add(itemmodel(R.drawable.male__1_, "Username", "Online", info))
        data.add(itemmodel(R.drawable.girl, "Username", "Online", info))
        data.add(itemmodel(R.drawable.male, "Username", "Offline", info1))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online", info))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online", info))
        data.add(itemmodel(R.drawable.male, "Username", "Online", info))
        data.add(itemmodel(R.drawable.girl, "Username", "Offline", info1))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online", info))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online", info))
        data.add(itemmodel(R.drawable.male, "Username", "Online", info))
        data.add(itemmodel(R.drawable.girl, "Username", "Offline", info1))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online", info))
        data.add(itemmodel(R.drawable.girl, "Username", "Online", info))
        data.add(itemmodel(R.drawable.doctor, "Username", "Offline", info1))
        data.add(itemmodel(R.drawable.male__1_, "Username", "Online", info))
        data.add(itemmodel(R.drawable.male, "Username", "Online", info))


        val adpter = rvadapteritem(data, this)
        recyclerView.adapter = adpter

       val itemTouchHelper=ItemTouchHelper(object :
       ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
           override fun onMove(
               recyclerView: RecyclerView,
               viewHolder: RecyclerView.ViewHolder,
               target: RecyclerView.ViewHolder
           ): Boolean {
              return false
           }

           @SuppressLint("NotifyDataSetChanged")
           override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
              val position=viewHolder.adapterPosition
                when(direction)
               {
                  ItemTouchHelper.LEFT->{
                      data.removeAt(position)
                      adpter.notifyDataSetChanged().apply {
                         Toast.makeText(applicationContext, "deleted", Toast.LENGTH_SHORT).show()
                      }
                  }
               }
           }
       })
        itemTouchHelper.attachToRecyclerView(recyclerView)

    }




    fun insalization() {
        recyclerView = findViewById(R.id.recyclerviewlist)



    }

}

