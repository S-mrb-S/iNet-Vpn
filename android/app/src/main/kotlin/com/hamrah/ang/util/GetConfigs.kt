package com.hamrah.ang.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import android.util.Log
import libv2ray.Libv2ray

class GetConfigsFromKotlin {
    suspend fun executeHeavyTask(): String {
        Log.d("START SHOD", "OPS")
        return withContext(Dispatchers.IO) {
            Libv2ray.getConfigs("https://t.me/s/v2rayng_org https://t.me/s/v2rayngvpn https://t.me/s/flyv2ray https://t.me/s/v2ray_outlineir")
        }
    }
}

