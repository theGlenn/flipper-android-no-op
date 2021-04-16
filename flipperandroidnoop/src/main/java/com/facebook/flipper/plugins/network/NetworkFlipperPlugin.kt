package com.facebook.flipper.plugins.network

import com.facebook.flipper.core.FlipperPlugin

class NetworkFlipperPlugin: FlipperPlugin {

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