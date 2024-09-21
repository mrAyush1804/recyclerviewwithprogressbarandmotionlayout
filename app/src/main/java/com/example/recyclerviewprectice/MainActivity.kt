package com.example.recyclerviewprectice

import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var secondrecyclerview:RecyclerView
    private lateinit var materialCardView: MaterialCardView
    private lateinit var rvadapteritem: rvadapteritem
    private lateinit var dataList: ArrayList<itemmodel>
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

        val data = ArrayList<itemmodel>()
        val info=ArrayList<secondlist>()
        info.add(secondlist(R.drawable.videocall,R.drawable.group_video_call,R.drawable.incoming_call,"Group call","Video Call","call"),)
        val info1=ArrayList<secondlist>()
        info1.add(secondlist(R.drawable.videocall,R.drawable.group_video_call,R.drawable.no_internet_connection,"Group call","Video Call","Network"),)




        data.add(itemmodel(R.drawable.male, "Username", "Online",info))
        data.add(itemmodel(R.drawable.girl, "Username", "Offline",info1))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online",info))
        data.add(itemmodel(R.drawable.male, "Username", "Online",info))
        data.add(itemmodel(R.drawable.girl, "Username", "Offline",info1))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online",info))
        data.add(itemmodel(R.drawable.girl, "Username", "Online",info))
        data.add(itemmodel(R.drawable.doctor, "Username", "Offline",info1))
        data.add(itemmodel(R.drawable.male__1_, "Username", "Online",info))
        data.add(itemmodel(R.drawable.male, "Username", "Online",info))
        data.add(itemmodel(R.drawable.doctor, "Username", "Offline",info1))
        data.add(itemmodel(R.drawable.male__1_, "Username", "Online",info))
        data.add(itemmodel(R.drawable.girl, "Username", "Online",info))
        data.add(itemmodel(R.drawable.male, "Username", "Offline",info1))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online",info))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online",info))
        data.add(itemmodel(R.drawable.male, "Username", "Online",info))
        data.add(itemmodel(R.drawable.girl, "Username", "Offline",info1))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online",info))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online",info))
        data.add(itemmodel(R.drawable.male, "Username", "Online",info))
        data.add(itemmodel(R.drawable.girl, "Username", "Offline",info1))
        data.add(itemmodel(R.drawable.doctor, "Username", "Online",info))
        data.add(itemmodel(R.drawable.girl, "Username", "Online",info))
        data.add(itemmodel(R.drawable.doctor, "Username", "Offline",info1))
        data.add(itemmodel(R.drawable.male__1_, "Username", "Online",info))
        data.add(itemmodel(R.drawable.male, "Username", "Online",info))



        val adpter = rvadapteritem(data, this)
        recyclerView.adapter = adpter


    }

    fun insalization() {
        recyclerView = findViewById(R.id.recyclerviewlist)



    }
}

