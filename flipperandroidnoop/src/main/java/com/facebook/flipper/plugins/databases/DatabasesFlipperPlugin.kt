package com.facebook.flipper.plugins.databases

import android.content.Context
import com.facebook.flipper.core.FlipperPlugin
import java.io.File
import java.util.*

class DatabasesFlipperPlugin : FlipperPlugin {
    constructor(context: Context?)

    constructor(databaseDriver: DatabaseDriver<*>?)

    constructor(databaseDriverList: ArrayList<DatabaseDriver<*>>?)

    fun onConnect(connection: Any?) {
    }

    fun onDisconnect() {

    }

    fun runInBackground() = false

    fun getDatabaseFiles(): List<File> = emptyList()


    companion object {
        @JvmStatic
        val ID: String = ""
    }
}
