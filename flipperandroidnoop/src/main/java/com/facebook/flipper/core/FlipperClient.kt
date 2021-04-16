package com.facebook.flipper.core

class FlipperClient {
    fun addPlugin(plugin: Any? = null) {
        // No-op
    }

    fun start() {
        // No-op
    }


    fun <T : Any?> getPlugin(id: String?): T? {
        return null
    }

    fun <T : Any?> getPluginByClass(cls: Class<T>?): T? {
        return null
    }

    fun removePlugin(plugin: Any?) {
        // No-op
    }


    fun stop() {
        // No-op
    }

    fun subscribeForUpdates(stateListener: Any?) {
        // No-op
    }

    fun unsubscribe() {
        // No-op

    }

    fun getState(): String? = null

    fun getStateSummary(): Any? = null
}