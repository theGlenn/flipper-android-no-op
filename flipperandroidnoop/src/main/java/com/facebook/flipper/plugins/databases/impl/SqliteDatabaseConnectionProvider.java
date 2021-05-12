package com.facebook.flipper.plugins.databases.impl;

import android.database.sqlite.SQLiteException;


import java.io.File;

public interface SqliteDatabaseConnectionProvider {
    Object openDatabase(File databaseFile) throws SQLiteException;
}
