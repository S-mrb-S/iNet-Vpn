package com.hamrah.ang.ui.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamrah.ang.R
import android.annotation.SuppressLint
import android.content.Intent
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
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

        val baseUrl = "file:///android_asset/hamrah_vpn"
        val htmlPath = "loginScreen.html"
        val unencodedHtml = assets.open(htmlPath).bufferedReader().use { it.readText() }

        webView.loadDataWithBaseURL(baseUrl, unencodedHtml, "text/html", "UTF-8", null)

//        val unencodedHtml =
//            "<html><body>'%23' is the percent code for ‘#‘ </body></html>";
//        val encodedHtml = Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)
//        webView.loadData(encodedHtml, "text/html", "base64")
        webView.addJavascriptInterface(jsInterface, "AndroidInterface")

        // AndroidInterface.sendDataToKotlin("Hello from JavaScript!")
    }
}
