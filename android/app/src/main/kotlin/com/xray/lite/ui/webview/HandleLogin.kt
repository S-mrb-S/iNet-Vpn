package com.xray.lite.ui.webview

import android.webkit.JavascriptInterface
import androidx.annotation.Keep
import org.json.JSONObject

class HandleLogin(private val callback: (String) -> Unit) {
    @JavascriptInterface
    @Keep
    fun sendDataToKotlin(data: String) {
        // Js to Kotlin
        try {
            val jsonObject = JSONObject(data)
            val name = jsonObject.optString("username", "")
            val pass = jsonObject.optString("password", "")

            if (name.isNotEmpty() && pass.isNotEmpty()) {
                callback.invoke(data)
            }

        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}
