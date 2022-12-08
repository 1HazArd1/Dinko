package com.example.dinko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val country: String = "in"
    lateinit var newsAdapter:NewsAdapter

    private companion object {
        const val BASE_URL: String = "https://newsapi.org/v2/"
        const val API: String = "7d4ce47f98054ec79f9a38d8696f6024"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //for getting data from retrofit
        getMyNews()
    }
    private fun getMyNews(){
        val retrofitBuilder=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(NewsApiInterface::class.java)

        val retrofitData=retrofitBuilder.getNews(country,100, API)

        retrofitData.enqueue(object : Callback<News?> {
            override fun onResponse(call: Call<News?>, response: Response<News?>) {
                val responseBody=response.body()!!
                newsAdapter= NewsAdapter(responseBody.articles,this@MainActivity)
                rv_News_Items.adapter=newsAdapter
                rv_News_Items.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                Log.d("NewsDataError","")
            }
        })
    }
}
