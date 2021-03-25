package com.facebook.flipper.core

/**
 * A FlipperPlugin is an object which exposes an API to the Desktop Flipper application. When a
 * connection is established the plugin is given a FlipperConnection on which it can register
 * request handlers and send messages. When the FlipperConnection is invalid onDisconnect is called.
 * onConnect may be called again on the same plugin object if Flipper re-connects, this will provide
 * a new FlipperConnection, do not attempt to re-use the previous connection.
 */
interface FlipperPlugin {

    /**
     * Called when a connection has been established. The connection passed to this method is valid
     * until [FlipperPlugin.onDisconnect] is called.
     */
    @Throws(Exception::class)
    fun onConnect(connection: Any?)

    /**
     * Called when the connection passed to [FlipperPlugin.onConnect] is no
     * longer valid. Do not try to use the connection in or after this method has been called.
     */
    @Throws(Exception::class)
    fun onDisconnect()

    /**
     * Returns true if the plugin is meant to be run in background too, otherwise it returns false.
     */
    fun runInBackground(): Boolean
}