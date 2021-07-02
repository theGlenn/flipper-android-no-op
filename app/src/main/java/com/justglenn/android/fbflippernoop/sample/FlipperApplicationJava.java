package com.justglenn.android.fbflippernoop.sample;


import android.app.Application;

import com.facebook.flipper.android.AndroidFlipperClient;
import com.facebook.flipper.android.utils.FlipperUtils;
import com.facebook.flipper.core.FlipperClient;
import com.facebook.flipper.plugins.crashreporter.CrashReporterPlugin;
import com.facebook.flipper.plugins.databases.DatabaseDescriptor;
import com.facebook.flipper.plugins.databases.DatabaseDriver;
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin;
import com.facebook.flipper.plugins.databases.impl.SqliteDatabaseDriver;
import com.facebook.flipper.plugins.databases.impl.SqliteDatabaseProvider;
import com.facebook.flipper.plugins.inspector.DescriptorMapping;
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin;
import com.facebook.flipper.plugins.leakcanary2.LeakCanary2FlipperPlugin;
import com.facebook.flipper.plugins.navigation.NavigationFlipperPlugin;
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin;
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin;
import com.facebook.soloader.SoLoader;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FlipperApplicationJava extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);

        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            final FlipperClient client = AndroidFlipperClient.getInstance(this);
            client.addPlugin(new InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()));

            client.addPlugin(new NetworkFlipperPlugin());

            client.addPlugin(new SharedPreferencesFlipperPlugin(this));
            client.addPlugin(new LeakCanary2FlipperPlugin());
            client.addPlugin(NavigationFlipperPlugin.getInstance());
            client.addPlugin(CrashReporterPlugin.getInstance());

            client.addPlugin(new DatabasesFlipperPlugin(this));

            client.addPlugin(new DatabasesFlipperPlugin(new SqliteDatabaseDriver(this, new SqliteDatabaseProvider() {
                @Override
                public List<File> getDatabaseFiles() {

                    List<File> databaseFiles = new ArrayList<>();
                    for (String databaseName : getBaseContext().databaseList()) {
                        databaseFiles.add(getBaseContext().getDatabasePath(databaseName));
                    }
                    //  databaseFiles.add("...path_to_your_db...");
                    return databaseFiles;
                }
            })));

            client.addPlugin(new DatabasesFlipperPlugin(new DatabaseDriver(this) {
                @Nullable
                @Override
                public DatabaseGetTableInfoResponse getTableInfo(@NotNull DatabaseDescriptor databaseDescriptor, @Nullable String table) {
                    return null;
                }

                @Override
                public List getDatabases() {
                    return null;
                }

                @Override
                public List<String> getTableNames(@NotNull DatabaseDescriptor databaseDescriptor) {
                    return null;
                }

                @Override
                public DatabaseGetTableDataResponse getTableData(@NotNull DatabaseDescriptor databaseDescriptor, String table, String order, boolean reverse, int start, int count) {
                    return null;
                }

                @Override
                public DatabaseGetTableStructureResponse getTableStructure(@NotNull DatabaseDescriptor databaseDescriptor, String table) {
                    return null;
                }

                @Override
                public DatabaseExecuteSqlResponse executeSQL(@NotNull DatabaseDescriptor databaseDescriptor, String query) {
                    return null;
                }
            }));

            client.start();
        }
    }
}