package com.facebook.flipper.plugins.sharedpreferences

import android.content.Context

class SharedPreferencesFlipperPlugin {

    constructor(context: Context)

    @JvmOverloads
    constructor(context: Context, name: String, mode: Int = Context.MODE_PRIVATE)

    constructor(context: Context, descriptors: List<SharedPreferencesDescriptor>)

    class SharedPreferencesDescriptor(name: String, mode: Int)
}