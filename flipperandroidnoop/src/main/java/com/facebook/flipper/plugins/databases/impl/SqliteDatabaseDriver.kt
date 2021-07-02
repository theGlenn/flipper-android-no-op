/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package com.facebook.flipper.plugins.databases.impl

import android.content.Context
import com.facebook.flipper.plugins.databases.DatabaseDescriptor
import com.facebook.flipper.plugins.databases.DatabaseDriver
import java.io.File


class SqliteDatabaseDriver @JvmOverloads constructor(
    context: Context?,
    private val sqliteDatabaseProvider: SqliteDatabaseProvider? = null,
    sqliteDatabaseConnectionProvider: Any? = null
) :
    DatabaseDriver<SqliteDatabaseDriver.SqliteDatabaseDescriptor?>(context!!) {

    override fun getDatabases(): List<SqliteDatabaseDescriptor>? {
        return null
    }

    override fun getTableNames(databaseDescriptor: SqliteDatabaseDescriptor?): List<String?>? {
        return null
    }

    override fun getTableData(
        databaseDescriptor: SqliteDatabaseDescriptor?,
        table: String?,
        order: String?,
        reverse: Boolean,
        start: Int,
        count: Int
    ): DatabaseGetTableDataResponse? {
        return null
    }

    override fun getTableStructure(
        databaseDescriptor: SqliteDatabaseDescriptor?,
        table: String?
    ): DatabaseGetTableStructureResponse? {
        return null
    }

    override fun getTableInfo(
        databaseDescriptor: SqliteDatabaseDescriptor?,
        table: String?
    ): DatabaseGetTableInfoResponse? {
        return null
    }

    override fun executeSQL(
        databaseDescriptor: SqliteDatabaseDescriptor?,
        query: String?
    ): DatabaseExecuteSqlResponse? {
        return null
    }

    class SqliteDatabaseDescriptor(private val file: File) : DatabaseDescriptor {
        override fun name(): String? {
            return file.name
        }
    }
}