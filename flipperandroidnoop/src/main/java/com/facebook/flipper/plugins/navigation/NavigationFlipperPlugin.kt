package com.facebook.flipper.plugins.navigation

import com.facebook.flipper.core.FlipperPlugin

class NavigationFlipperPlugin: FlipperPlugin {

    override fun onConnect(connection: Any?) {
        // no op
    }

    override fun onDisconnect() {
        // no op
    }

    override fun runInBackground(): Boolean = false

    companion object {
        @JvmStatic
        fun getInstance() = NavigationFlipperPlugin()

        @JvmStatic
        val ID: String = ""
    }
}