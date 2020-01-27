package com.facebook.flipper.plugins.crashreporter

class CrashReporterPlugin {
    companion object {
        @JvmStatic
        fun getInstance() = CrashReporterPlugin()
    }

    fun sendExceptionMessage(paramThread: Thread, paramThrowable: Throwable) {}
}