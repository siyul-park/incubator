package com.ara.incubator.database.exposed.table

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object Accounts : UUIDTable() {
    val username = text("username").index()
    val password = text("password")

    val createdAt = datetime("created_at").default(LocalDateTime.now())
    val updatedAt = datetime("updated_at").default(LocalDateTime.now())
}