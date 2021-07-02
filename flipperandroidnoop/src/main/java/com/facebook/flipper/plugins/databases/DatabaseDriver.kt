
package com.facebook.flipper.plugins.databases

import android.content.Context
import androidx.annotation.StringDef

abstract class DatabaseDriver<DESCRIPTOR : DatabaseDescriptor?>(val context: Context) {
    abstract fun getDatabases(): List<DESCRIPTOR>?

    abstract fun getTableNames(databaseDescriptor: DESCRIPTOR): List<String?>?
    abstract fun getTableData(
        databaseDescriptor: DESCRIPTOR,
        table: String?,
        order: String?,
        reverse: Boolean,
        start: Int,
        count: Int
    ): DatabaseGetTableDataResponse?

    abstract fun getTableStructure(
        databaseDescriptor: DESCRIPTOR, table: String?
    ): DatabaseGetTableStructureResponse?

    abstract fun getTableInfo(
        databaseDescriptor: DESCRIPTOR, table: String?
    ): DatabaseGetTableInfoResponse?

    abstract fun executeSQL(
        databaseDescriptor: DESCRIPTOR, query: String?
    ): DatabaseExecuteSqlResponse?

    class DatabaseGetTableDataResponse(
        val columns: List<String>,
        val values: List<List<Any>>,
        val start: Int,
        val count: Int,
        val total: Long
    )

    class DatabaseGetTableStructureResponse(
        val structureColumns: List<String>,
        val structureValues: List<List<Any>>,
        val indexesColumns: List<String>,
        val indexesValues: List<List<Any>>
    )

    class DatabaseGetTableInfoResponse(val definition: String)
    class DatabaseExecuteSqlResponse private constructor(
        @field:Type @param:Type val type: String,
        // Select
        val columns: List<String>?,
        val values: List<List<Any>>?,
        // insert
        val insertedId: Long?,
        // update/delete
        val affectedCount: Int?
    ) {
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        @StringDef(
            TYPE_SELECT, TYPE_INSERT, TYPE_UPDATE_DELETE, TYPE_RAW
        )
        annotation class Type

        companion object {
            const val TYPE_SELECT = "select"
            const val TYPE_INSERT = "insert"
            const val TYPE_UPDATE_DELETE = "update_delete"
            const val TYPE_RAW = "raw"
            fun successfulSelect(
                columns: List<String>?, values: List<List<Any>>?
            ): DatabaseExecuteSqlResponse {
                return DatabaseExecuteSqlResponse(TYPE_SELECT, columns, values, null, null)
            }

            fun successfulInsert(insertedId: Long): DatabaseExecuteSqlResponse {
                return DatabaseExecuteSqlResponse(TYPE_INSERT, null, null, insertedId, null)
            }

            fun successfulUpdateDelete(affectedRows: Int): DatabaseExecuteSqlResponse {
                return DatabaseExecuteSqlResponse(
                    TYPE_UPDATE_DELETE,
                    null,
                    null,
                    null,
                    affectedRows
                )
            }

            fun successfulRawQuery(): DatabaseExecuteSqlResponse {
                return DatabaseExecuteSqlResponse(TYPE_RAW, null, null, null, null)
            }
        }
    }
}