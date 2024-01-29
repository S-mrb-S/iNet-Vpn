package com.xray.lite

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tencent.mmkv.MMKV
import com.xray.lite.extension.toast
import com.xray.lite.ui.MainActivity
import com.xray.lite.ui.webview.WebViewLogin

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //
        try {
            if (isFirstRun()) {
                toast("Skip SplashScreen!")
                intentToMainActivity()
            } else {
                toast("Config add!")
                Handler(Looper.getMainLooper()).postDelayed({
                    initializeApp()
                }, 4500)
            }
            //
        }catch (e: Exception) {
            toast("Error when loading!")
            Log.d("Error this: ", e.toString())
            toast("Skip error!")
            intentToMainActivity()
        }
    }

    private var doubleBackToExitPressedOnce = false
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        if (doubleBackToExitPressedOnce) {
            finish()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "برای خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

    private fun initializeApp() {
        if (isLogin()) {
           try {
               intentToMainActivity()
                toast("Welcome!")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }else{
            try {
                toast("Login screen!")
//                setContentView(R.layout.activity_main_login)
                val intent = Intent(this, WebViewLogin::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) //or Intent.FLAG_ACTIVITY_CLEAR_TOP Intent.FLAG_ACTIVITY_CLEAR_TASK or or Intent.FLAG_ACTIVITY_SINGLE_TOP
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
//                val myFragment = FullscreenFragment()
//                val loginFrag = LoginFragment()
//                //
//                val fragmentManager: FragmentManager = supportFragmentManager
//                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//                //
//                fragmentTransaction.replace(android.R.id.content, myFragment)
//                fragmentTransaction.addToBackStack(null)
//                fragmentTransaction.commit()
//                //
//                val secondTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//                secondTransaction.add(android.R.id.content, loginFrag)
//                secondTransaction.addToBackStack(null)
//                secondTransaction.commit()
            } catch (e: Exception) {
                e.printStackTrace()
                toast("Error when creating LoginScreen!")
            } finally {
                toast("Finish activity!")
//                finish() // important
            }
        }
    }

    fun slideUp(view: View?) {
//        startActivity(Intent(this, WelcomeActivity::class.java))
        toast("LOGIN")
//        customType(this, "bottom-to-up")intentToMainActivity
        intentToMainActivity()
    }

    private fun isLogin(): Boolean {
        val mmkv = MMKV.defaultMMKV()
        return mmkv.decodeBool("isLogin", false)
    }

    private fun saveLogin() {
        val mmkv = MMKV.defaultMMKV()
        mmkv.encode("isLogin", true)
    }

    private fun isFirstRun(): Boolean {
        val mmkv = MMKV.defaultMMKV()
        return mmkv.decodeBool("isFirstRun", false)
    }

    private fun intentToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) //or Intent.FLAG_ACTIVITY_CLEAR_TOP Intent.FLAG_ACTIVITY_CLEAR_TASK or or Intent.FLAG_ACTIVITY_SINGLE_TOP
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

}
