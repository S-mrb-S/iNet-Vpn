package com.hamrah.ang.ui.webview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.hamrah.ang.R
import com.hamrah.ang.extension.toast
import com.hamrah.ang.ui.MainActivity
import org.json.JSONObject

class WebViewLogin : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val webView: WebView = findViewById(R.id.webViewLogin)
        val webSettings: WebSettings = webView.settings
        webSettings.builtInZoomControls = false;
        webSettings.setSupportZoom(false);
        webSettings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()

        val jsInterface = HandleLogin { data ->
            val jsonObject = JSONObject(data)

            val name = jsonObject.getString("username")
            val pass = jsonObject.getString("password")
            toast("name: $name")

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        val baseUrl = "file:///android_asset/"
        val htmlPath = "loginScreen.html"
        val unencodedHtml = assets.open(htmlPath).bufferedReader().use { it.readText() }

        webView.loadDataWithBaseURL(baseUrl, unencodedHtml, "text/html", "UTF-8", null)

        webView.addJavascriptInterface(jsInterface, "AndroidInterface")

        // AndroidInterface.sendDataToKotlin("Hello from JavaScript!")
    }
}
