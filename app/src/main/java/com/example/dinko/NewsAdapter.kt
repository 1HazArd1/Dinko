package com.example.dinko

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private var newsDataList: ArrayList<NewsData>):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){
    private var tvNewsTitle:TextView?=null

    inner class NewsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.news_items,parent,false)
        tvNewsTitle=view.findViewById(R.id.tv_News_Title)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.itemView.apply {
            tvNewsTitle?.text=newsDataList[position].Title
        }
    }

    override fun getItemCount(): Int {
        return newsDataList.size
    }

}