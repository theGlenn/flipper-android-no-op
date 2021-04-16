package com.facebook.flipper.plugins.crashreporter

import com.facebook.flipper.core.FlipperPlugin

class CrashReporterPlugin : FlipperPlugin {

    fun sendExceptionMessage(paramThread: Thread, paramThrowable: Throwable) {}

    override fun onConnect(connection: Any?) {
        // no op
    }

    override fun onDisconnect() {
        // no op
    }

    override fun runInBackground(): Boolean = false

    companion object {
        @JvmStatic
        fun getInstance() = CrashReporterPlugin()

        @JvmStatic
        val ID: String = ""
    }

}