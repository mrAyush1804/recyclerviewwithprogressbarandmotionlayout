package com.example.recyclerviewprectice

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView

class MainActivity2 : AppCompatActivity() {
    private lateinit var materialCardView: MaterialCardView
    private lateinit var materialCardView2: MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor=ContextCompat.getColor(this,R.color.Space)
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

         materialCardView=findViewById(R.id.materialToolbar)
        materialCardView2=findViewById(R.id.mcv_2)

        materialCardView.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)

        })

        materialCardView2.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,MainActivity3::class.java)
            startActivity(intent)
        })




    }
}