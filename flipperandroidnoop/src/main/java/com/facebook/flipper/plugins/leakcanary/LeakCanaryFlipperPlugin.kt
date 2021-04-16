package com.facebook.flipper.plugins.leakcanary

import com.facebook.flipper.core.FlipperPlugin

class LeakCanaryFlipperPlugin: FlipperPlugin {

    override fun onConnect(connection: Any?) {
        // no op
    }

    override fun onDisconnect() {
        // no op
    }

    override fun runInBackground(): Boolean = false

    companion object {
        @JvmStatic
        val ID: String = ""
    }

}