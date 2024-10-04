package com.example.recyclerviewprectice

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import kotlin.math.abs

class MainActivity3 : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var dotsLayout: LinearLayout
    private val dots = mutableListOf<ImageView>()
    private var data = ArrayList<viewpagerdata>()


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
        addData()
        pagesetr()


        val viewPagerAdpter = ViewPagerAdpter(data, this)
        viewPager2.adapter = viewPagerAdpter
        setupDotIndicator(data.size)


        // viewPager2.setPageTransformer(compositePageTransformer)

        viewPager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }


            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateDots(position)
            }


            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        });


    }


    private fun setupDotIndicator(totalPages: Int) {
        dots.clear()
        for (i in 0 until totalPages) {
            val dot = ImageView(this).apply {
                setImageResource(R.drawable.colour_dot_indicater)
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(8, 0, 8, 0)
                }
                layoutParams = params
            }
            dotsLayout.addView(dot)
            dots.add(dot)
        }


        updateDots(0)
    }


    private fun updateDots(position: Int) {
        for (i in dots.indices) {
            if (i == position) {
                dots[i].setImageResource(R.drawable.colour_dot_indicater)
            } else {
                dots[i].setImageResource(R.drawable.non_colour_dot)
            }
        }
    }


    fun inisliazation() {
        viewPager2 = findViewById(R.id.viewpager2)
        dotsLayout = findViewById(R.id.dotindicater)
    }

    fun addData() {
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
        data.add(viewpagerdata(R.drawable.male, "Hello I am anuska", R.drawable.group_video_call))

    }

    private fun pagesetr() {

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer(object : ViewPager2.PageTransformer {
            override fun transformPage(page: View, position: Float) {

                val r = 1 - abs(position)
                page.scaleY = 0.45f + r * 0.45f

            }



        })

        compositePageTransformer.addTransformer { page, position ->
            if (position < -1 || position > 1) {
                page.alpha = 0f
            } else if (position <= 0) {
                page.alpha = 1 + position // fade in
                page.translationZ = 1f // z-axis translation
            } else {
                page.alpha = 1 - position // fade out
                page.translationZ = 1f // z-axis translation
            }
        }

        viewPager2.setPageTransformer(compositePageTransformer)
        }




}



