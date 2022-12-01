package com.example.dinko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var rvNewsItems:RecyclerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNewsItems=findViewById(R.id.rv_News_Items)

        rvNewsItems?.adapter=NewsAdapter(getNewsData())
        rvNewsItems?.layoutManager=LinearLayoutManager(this)



    }

    private fun getNewsData():ArrayList<NewsData>{
       val newsTitleList=ArrayList<NewsData>()
        for(i in 1 until 100){
            newsTitleList.add(NewsData("item $i"))
        }
        return newsTitleList
    }
}