package com.facebook.flipper.plugins.databases.impl

import android.content.Context
import com.facebook.flipper.plugins.databases.DatabaseDriver

class SqliteDatabaseDriver() : DatabaseDriver<Nothing>() {

    constructor(context:Context?): this()
    constructor(context:Context?, sqliteDatabaseProvider: SqliteDatabaseProvider):this()
    constructor(context:Context?, sqliteDatabaseProvider: SqliteDatabaseProvider, sqliteDatabaseConnectionProvider: SqliteDatabaseConnectionProvider):this()

}
