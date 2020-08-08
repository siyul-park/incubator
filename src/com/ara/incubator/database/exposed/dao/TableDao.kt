package com.ara.incubator.database.exposed.dao

import com.ara.incubator.database.core.dao.TableDao
import com.ara.incubator.database.exposed.transaction.Transactor
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table

class TableDao<TABLE : Table>(
    private val transactor: Transactor,
    private val inBatch: Boolean = false
) : TableDao<TABLE> {
    override suspend fun create(vararg table: TABLE) = transactor.transaction {
        SchemaUtils.create(*table, inBatch = inBatch)
        table.toList()
    }
}