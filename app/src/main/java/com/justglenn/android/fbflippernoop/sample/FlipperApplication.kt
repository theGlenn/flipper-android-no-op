package com.justglenn.android.fbflippernoop.sample

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.crashreporter.CrashReporterPlugin
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.leakcanary2.FlipperLeakListener
import com.facebook.flipper.plugins.leakcanary2.LeakCanary2FlipperPlugin
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.soloader.SoLoader
import leakcanary.LeakCanary

class FlipperApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        SoLoader.init(this, false)

        installFlipper()
    }

    private fun installFlipper() {
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {

            LeakCanary.config = LeakCanary.config.copy(
                onHeapAnalyzedListener = FlipperLeakListener()
            )

            AndroidFlipperClient.getInstance(this).apply {
                addPlugin(NetworkFlipperPlugin())
                addPlugin(InspectorFlipperPlugin(this@FlipperApplication, DescriptorMapping.withDefaults()))
                addPlugin(DatabasesFlipperPlugin(this@FlipperApplication))
                addPlugin(SharedPreferencesFlipperPlugin(this@FlipperApplication))
                addPlugin(LeakCanary2FlipperPlugin())
                addPlugin(NavigationFlipperPlugin.getInstance())
                addPlugin(CrashReporterPlugin.getInstance())
                start()
            }
        }
    }
}