package com.hamrah.ang.util

import kotlin.system.exitProcess

class GlobalExceptionHandler : Thread.UncaughtExceptionHandler {
    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        // این قسمت بر اساس نیاز شما قابل گسترش و تغییر است
        println("Unhandled exception in thread: ${thread.name}")
        throwable.printStackTrace()

        // Log
        exitProcess(1)
    }
}
