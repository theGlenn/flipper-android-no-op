package com.facebook.flipper.android

import android.content.Context

object AndroidFlipperClient {
    @Synchronized
    fun getInstance(context: Context): FlipperClient = FlipperClient()
}