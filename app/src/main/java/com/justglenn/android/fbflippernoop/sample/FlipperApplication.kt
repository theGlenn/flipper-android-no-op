package com.justglenn.android.fbflippernoop.sample

import android.app.Application
import com.facebook.flipper.BuildConfig
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.core.FlipperConnection
import com.facebook.flipper.plugins.crashreporter.CrashReporterPlugin
import com.facebook.flipper.plugins.databases.DatabaseDescriptor
import com.facebook.flipper.plugins.databases.DatabaseDriver
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.flipper.plugins.databases.impl.SqliteDatabaseDriver
import com.facebook.flipper.plugins.databases.impl.SqliteDatabaseProvider
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.leakcanary2.FlipperLeakListener
import com.facebook.flipper.plugins.leakcanary2.LeakCanary2FlipperPlugin
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.flipper.plugins.uidebugger.UIDebuggerFlipperPlugin
import com.facebook.flipper.plugins.uidebugger.core.UIDContext
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

            val client = AndroidFlipperClient.getInstance(this)
            client.addPlugin(NetworkFlipperPlugin())
            client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))

            client.addPlugin(SharedPreferencesFlipperPlugin(this))
            client.addPlugin(LeakCanary2FlipperPlugin())
            client.addPlugin(NavigationFlipperPlugin.getInstance())
            client.addPlugin(CrashReporterPlugin.getInstance())

            // DatabasesFlipperPlugin
            client.let {
                it.addPlugin(DatabasesFlipperPlugin(this))
                it.addPlugin(
                    DatabasesFlipperPlugin(
                        SqliteDatabaseDriver(
                            this,
                            SqliteDatabaseProvider { emptyList() })
                    )
                )

                it.addPlugin(DatabasesFlipperPlugin(object :
                    DatabaseDriver<DatabaseDescriptor>(this) {
                    override fun getDatabases(): MutableList<DatabaseDescriptor>? = null
                    override fun getTableNames(databaseDescriptor: DatabaseDescriptor): List<String?>? =
                        null

                    override fun getTableData(
                        databaseDescriptor: DatabaseDescriptor,
                        table: String?,
                        order: String?,
                        reverse: Boolean,
                        start: Int,
                        count: Int
                    ): DatabaseGetTableDataResponse? = null

                    override fun getTableStructure(
                        databaseDescriptor: DatabaseDescriptor,
                        table: String?
                    ): DatabaseGetTableStructureResponse? = null

                    override fun executeSQL(
                        databaseDescriptor: DatabaseDescriptor,
                        query: String?
                    ): DatabaseExecuteSqlResponse? = null

                    override fun getTableInfo(
                        databaseDescriptor: DatabaseDescriptor,
                        table: String?
                    ): DatabaseGetTableInfoResponse? = null
                }))
            }

            val uidContext: UIDContext = UIDContext.Companion.create(this)
            UIDebuggerLithoSupport.INSTANCE.enable(uidContext)

            client.addPlugin(UIDebuggerFlipperPlugin(uidContext))
            client.start()
        }
    }
}