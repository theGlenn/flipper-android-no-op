package com.facebook.flipper.plugins.inspector

import android.content.Context
import com.facebook.flipper.core.FlipperPlugin

class InspectorFlipperPlugin(context: Context, descriptorMapping: DescriptorMapping): FlipperPlugin {

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