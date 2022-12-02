package com.example.dinko

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_items.view.*

class NewsAdapter(private val newsData:List<NewsData>,private val cont: Context):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var tvNewsTitle: TextView
        var tvNewsDescription:TextView
        var tvNewsAuthor:TextView
        var cvNewsItems: CardView
        var imgNews: ImageView

        init {
            tvNewsTitle=itemView.tv_News_Title
            tvNewsAuthor=itemView.tv_news_author
            tvNewsDescription=itemView.tv_news_description
            cvNewsItems=itemView.cv_news_items
            imgNews=itemView.img_News
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_items,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int){
        holder.apply {
            tvNewsTitle.text=newsData[position].title
            tvNewsDescription.text=newsData[position].description
            tvNewsAuthor.text=newsData[position].author
            cvNewsItems.setOnClickListener {
                val intent= Intent(cont,WebView::class.java)
                intent.putExtra("url",newsData[position].url)
                cont.startActivity(intent)
            }
            Picasso.get().load(newsData[position].urlToImage).into(imgNews)
        }

}

    override fun getItemCount(): Int {
        return newsData.size
    }

}