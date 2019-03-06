package com.facebook.flipper.plugins.leakcanary

import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher

//TODO fin a workaround
fun LeakCanary.refWatcher(context: Any? = null) = object {
    fun listenerServiceClass(listenerServiceClass: Class<out Any>): Any = this
    fun buildAndInstall(): RefWatcher = RefWatcher.DISABLED
}