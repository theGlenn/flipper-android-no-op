package com.facebook.flipper.plugins.databases

import android.content.Context
import com.facebook.flipper.core.FlipperPlugin
import java.util.*

class DatabasesFlipperPlugin:FlipperPlugin {
    constructor(context: Context?)

    constructor(databaseDriver: DatabaseDriver<*>?)

    constructor(databaseDriverList: ArrayList<DatabaseDriver<*>>?)

    override fun onConnect(connection: Any?) {
    }

    override fun onDisconnect() {

    }

    override fun runInBackground() = false

    companion object {
        @JvmStatic
        val ID: String = ""
    }
}
