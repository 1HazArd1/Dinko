package com.example.dinko

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.sports_fragment.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SportsFragment: Fragment() {
    private val country: String = "in"
    private val category:String = "sports"
    lateinit var newsAdapter:NewsAdapter
    private companion object {
        const val BASE_URL: String = "https://newsapi.org/v2/"
        const val API: String = "7d4ce47f98054ec79f9a38d8696f6024"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= layoutInflater.inflate(R.layout.sports_fragment,container,false)
        val retrofitBuilder= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(NewsApiInterface::class.java)

        val retrofitData=retrofitBuilder.getCategoryNews(country,category,100,API)

        retrofitData.enqueue(object : Callback<News?> {
            override fun onResponse(call: Call<News?>, response: Response<News?>) {
                val responseBody=response.body()!!
                newsAdapter= NewsAdapter(responseBody.articles,context!!)
                view.rv_sports.adapter=newsAdapter
                view.rv_sports.layoutManager = LinearLayoutManager(context!!)
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                Log.d("NewsDataError","")
            }
        })
        return view
    }
}