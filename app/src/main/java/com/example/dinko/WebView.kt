package com.example.dinko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val webUrl=intent.getStringExtra("url").toString()
        webView.webViewClient=WebViewClient()
        webView.loadUrl(webUrl)
        webView.settings.setSupportZoom(true)
    }
    // if you press Back button this code will work
    override fun onBackPressed() {
        // if your web view can go back it will go back
        if (webView.canGoBack())
            webView.goBack()
        // if your web view cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    }
}


