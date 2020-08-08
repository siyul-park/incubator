package com.ara.incubator.database.core

import com.ara.incubator.initializer.Initializer
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction

class DataBaseInitializer : Initializer<DataBaseConfiguration> {
    lateinit var context: DataBaseContext

    override fun init(configuration: DataBaseConfiguration) {
        val database = Database.connect(configuration.source)
        transaction {
            create(*configuration.tables.toTypedArray())
        }

        context = object : DataBaseContext {
            override val database: Database
                get() = database
            override val tables: Collection<Table>
                get() = configuration.tables
        }
    }
}