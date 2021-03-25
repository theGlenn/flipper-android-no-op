package com.facebook.flipper.plugins.leakcanary2

import com.facebook.flipper.core.FlipperPlugin


class LeakCanary2FlipperPlugin: FlipperPlugin {

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