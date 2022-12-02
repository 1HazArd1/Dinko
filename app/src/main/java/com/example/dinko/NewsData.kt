package com.example.dinko

data class NewsData(
    val author: String,
    val content: String,    // this is article
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)