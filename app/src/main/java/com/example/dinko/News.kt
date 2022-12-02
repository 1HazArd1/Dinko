package com.example.dinko

data class News(
    val articles: ArrayList<NewsData>,
    val status: String,  //this is newsData
    val totalResults: Int
)