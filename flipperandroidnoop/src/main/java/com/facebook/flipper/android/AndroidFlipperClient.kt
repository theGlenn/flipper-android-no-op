package com.facebook.flipper.android

import android.content.Context
import com.facebook.flipper.core.FlipperClient

object AndroidFlipperClient {
    @Synchronized
    fun getInstance(context: Context): FlipperClient =
        FlipperClient()
}