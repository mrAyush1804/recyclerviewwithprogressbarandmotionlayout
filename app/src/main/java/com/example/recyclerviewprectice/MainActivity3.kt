package com.example.recyclerviewprectice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback

class MainActivity3 : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        inisliazation()
        val data = ArrayList<viewpagerdata>()
        data.add(viewpagerdata(R.drawable.girl, "Hello I am anuska", R.drawable.group_video_call))
        data.add(viewpagerdata(R.drawable.doctor, "Hello I am Docter", R.drawable.incoming_call))
        data.add(viewpagerdata(R.drawable.male, "Hello I am ayush", R.drawable.group_video_call))
        data.add(
            viewpagerdata(
                R.drawable.male__1_,
                "Hello I am bill gets",
                R.drawable.incoming_call
            )
        )
        data.add(
            viewpagerdata(
                R.drawable.girl,
                "Hello I am brain less",
                R.drawable.group_video_call
            )
        )
        data.add(viewpagerdata(R.drawable.doctor, "Hello I am anuska", R.drawable.incoming_call))
        data.add(viewpagerdata(R.drawable.male, "Hello I am anuska", R.drawable.group_video_call))
        data.add(
            viewpagerdata(
                R.drawable.male__1_,
                "Hello I am anuska",
                R.drawable.group_video_call
            )
        )
        data.add(viewpagerdata(R.drawable.girl, "Hello I am anuska", R.drawable.group_video_call))
        data.add(viewpagerdata(R.drawable.doctor, "Hello I am Docter", R.drawable.incoming_call))
        data.add(viewpagerdata(R.drawable.male, "Hello I am ayush", R.drawable.group_video_call))
        data.add(
            viewpagerdata(
                R.drawable.male__1_,
                "Hello I am bill gets",
                R.drawable.incoming_call
            )
        )
        data.add(
            viewpagerdata(
                R.drawable.girl,
                "Hello I am brain less",
                R.drawable.group_video_call
            )
        )
        data.add(viewpagerdata(R.drawable.doctor, "Hello I am anuska", R.drawable.incoming_call))
        data.add(viewpagerdata(R.drawable.male, "Hello I am anuska", R.drawable.group_video_call))
        data.add(
            viewpagerdata(
                R.drawable.male__1_,
                "Hello I am anuska",
                R.drawable.group_video_call
            )
        )
        data.add(viewpagerdata(R.drawable.male, "Hello I am anuska", R.drawable.group_video_call))
        data.add(viewpagerdata(R.drawable.male, "Hello I am anuska", R.drawable.group_video_call))
        data.add(viewpagerdata(R.drawable.male, "Hello I am anuska", R.drawable.group_video_call))

        val viewPagerAdpter = ViewPagerAdpter(data, this)
        viewPager2.adapter = viewPagerAdpter

        viewPager2.registerOnPageCh j bjbjk bjkb jkbd jkbjk
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }


            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }


            override fun dc hjwdv jhv   hjvbk jw    bcjkbonPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        });

    }

    fun ayush()
    {
        println("first branch")
    }
 fun ravi()
    {
        println("first branch")
    }

    bdbvk mn nehj  x n, hj  chjdbxhjJ

    fun inisliazation() {
        viewPager2 = findViewById(R.id.viewpager2)
    }
}