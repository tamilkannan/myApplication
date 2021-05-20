package com.example.myapplication

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    private lateinit var webView1: WebView
    private lateinit var progress1: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView1 = findViewById(R.id.webView1)
        progress1 = findViewById(R.id.progress1)

        webView1.loadUrl("https://www.genpower.tech/")
        val settings = webView1.settings
        settings.javaScriptEnabled = true

        webView1.webChromeClient= object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress >= 100){
                    progress1.visibility = View.GONE
                    webView1.visibility = View.VISIBLE
                }
            }
        }

    }
}