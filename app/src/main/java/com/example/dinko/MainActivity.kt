package com.example.dinko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val categoryArray= arrayOf("Home","Health","Sports","Entertainment","Science","Technology")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val viewPagerAdapter=ViewPagerAdapter(this)

        fragment_container.adapter=viewPagerAdapter
        TabLayoutMediator(tab_category,fragment_container){tab,position -> tab.text=categoryArray[position]}.attach()

    }

}
