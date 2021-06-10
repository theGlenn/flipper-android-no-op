package com.facebook.flipper.plugins.crashreporter

import com.facebook.flipper.core.FlipperPlugin

class CrashReporterPlugin : FlipperPlugin {

    fun sendExceptionMessage(paramThread: Thread, paramThrowable: Throwable) {}

    companion object {
        @JvmStatic
        fun getInstance() = CrashReporterPlugin()

        @JvmStatic
        val ID: String = ""
    }

}