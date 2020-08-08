package com.ara.incubator.database.core

import org.jetbrains.exposed.sql.Table
import javax.sql.DataSource

class DataBaseConfiguration(
    val source: DataSource,
    val tables: Collection<Table>
)