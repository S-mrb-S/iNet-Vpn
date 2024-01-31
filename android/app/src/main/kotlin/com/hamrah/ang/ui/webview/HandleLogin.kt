package com.hamrah.ang.ui.webview

import android.net.VpnService
import android.webkit.JavascriptInterface
import androidx.annotation.Keep
import com.hamrah.ang.AppConfig
import com.hamrah.ang.ui.MainActivity
import com.hamrah.ang.util.Utils
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
    @JavascriptInterface
    @Keep
    fun sendEventToKotlin() {
        // Js to Kotlin
        try {
            callback.invoke("event")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Keep
    fun sendCheckboxValueToKotlin(data: String) {
        // Js to Kotlin
        try {
            val jsonObject = JSONObject(data)
            val name = jsonObject.optString("username", "")
            val pass = jsonObject.optString("password", "")

            if (name.isNotEmpty() && pass.isNotEmpty()) {
                callback.invoke(data)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
