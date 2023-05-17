package com.example.solarapp

import android.content.Context
import android.media.Image
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val connectionManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork : NetworkInfo? = connectionManager.activeNetworkInfo
        val isConnected:Boolean = activeNetwork?.isConnectedOrConnecting == true
        val img = findViewById<ImageView>(R.id.imageView2)
        val txt = findViewById<TextView>(R.id.textView2)
        val btn = findViewById<Button>(R.id.button)
        val webView = findViewById<WebView>(R.id.webView)
    if (isConnected){
        webView.visibility = View.VISIBLE
        img.visibility = View.INVISIBLE
        txt.visibility = View.INVISIBLE
        btn.visibility = View.INVISIBLE
    } else {
        webView.visibility = View.INVISIBLE
        img.visibility = View.VISIBLE
        txt.visibility = View.VISIBLE
        btn.visibility = View.VISIBLE

    }

        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://alekd1.github.io/solar")
        webView.settings.javaScriptEnabled=true
        webView.settings.setSupportZoom(true)

        btn.setOnClickListener {
            val activeNetwork : NetworkInfo? = connectionManager.activeNetworkInfo
            val isConnected:Boolean = activeNetwork?.isConnectedOrConnecting == true
            if (isConnected){
                img.visibility = View.INVISIBLE
                txt.visibility = View.INVISIBLE
                btn.visibility = View.INVISIBLE
                webView.visibility = View.VISIBLE
            } else {
                webView.visibility = View.INVISIBLE
                img.visibility = View.VISIBLE
                txt.visibility = View.VISIBLE
                btn.visibility = View.VISIBLE
            }
        }





    }
}