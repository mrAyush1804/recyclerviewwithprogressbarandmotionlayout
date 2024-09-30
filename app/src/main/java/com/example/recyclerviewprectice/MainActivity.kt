package com.example.recyclerviewprectice

import InfiniteScrollListener

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var rvadapteritem: rvadapteritem
    private lateinit var dataList: ArrayList<itemmodel>
    private lateinit var info: ArrayList<secondlist>
    var infiniteScrollListener: InfiniteScrollListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        initializeViews()
        initializeInfo()
        populateData()
        setupSwipeToDelete()


        recyclerView.layoutManager = LinearLayoutManager(this)
        rvadapteritem = rvadapteritem(dataList, this)
        recyclerView.adapter = rvadapteritem

        val manager = LinearLayoutManager(this)
        infiniteScrollListener = InfiniteScrollListener(manager, this)
        infiniteScrollListener!!.setLoaded()



        recyclerView.layoutManager = manager
        recyclerView.addOnScrollListener(infiniteScrollListener!!)
        /** ye recical viwew ke decoration ke liye use ho raha ha ***/

        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))



    }

    private fun initializeViews() {
        recyclerView = findViewById(R.id.recyclerviewlist)
    }

    private fun initializeInfo() {
        info = ArrayList()


        info.add(
            secondlist(
                R.drawable.videocall,
                R.drawable.group_video_call,
                R.drawable.incoming_call,
                "Group call",
                "Video Call",
                "call"
            )
        )


    }

    private fun populateData() {
        dataList = ArrayList()
        var usernameCount = 0
        for (i in 0 until 4) {
            dataList.add(itemmodel(R.drawable.male, "Username ", if (i % 2 == 0) "Online" else "Offline", info))
            dataList.add(itemmodel(R.drawable.doctor, "Username ", if (i % 2 == 0) "Online" else "Offline", info))
            dataList.add(itemmodel(R.drawable.girl, "Username ", if (i % 2 == 0) "Online" else "Offline", info))
            dataList.add(itemmodel(R.drawable.male__1_, "Username ", if (i % 2 == 0) "Online" else "Offline", info))
            usernameCount++
        }
    }
  /** ye swip to deleate karne ke liye jab tum left
  *swap karo ge tho item deleat ho jaye ga recycalview se***/

    private fun setupSwipeToDelete() {
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }


            @SuppressLint("NotifyDataSetChanged")
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    dataList.removeAt(position)
                    rvadapteritem.notifyItemRemoved(position)
                    Toast.makeText(applicationContext, "Item deleted", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float,
                                     dY: Float,
                                     actionState: Int,
                                     isCurrentlyActive: Boolean
            ) {
                RecyclerViewSwipeDecorator.Builder(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
                    .addBackgroundColor(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.green
                        )
                    )
                    .addSwipeLeftLabel("Item remove")
                    .create()
                    .decorate()


                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

            }
        })
        itemTouchHelper.attachToRecyclerView(recyclerView)


    }



    @SuppressLint("NotifyDataSetChanged")
     fun loadMore(NUM_LOAD_ITEMS: Int) {
        val handler = Handler()
        handler.postDelayed({
            val currentSize = NUM_LOAD_ITEMS
            for (i in currentSize until currentSize + 2) {
                dataList.add(itemmodel(R.drawable.male, "Username ", if (i % 2 == 0) "Online" else "Offline", info))
                dataList.add(itemmodel(R.drawable.doctor, "Username ", if (i % 2 == 0) "Online" else "Offline", info))
                dataList.add(itemmodel(R.drawable.girl, "Username ", if (i % 2 == 0) "Online" else "Offline", info))
                dataList.add(itemmodel(R.drawable.male__1_, "Username ", if (i % 2 == 0) "Online" else "Offline", info))
            }
            rvadapteritem.notifyDataSetChanged()
           infiniteScrollListener?.setLoaded()

        }, 2000)
    }
}
