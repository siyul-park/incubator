package com.ara.incubator.database.exposed.dao

import com.ara.incubator.database.core.dao.TransactionalDao
import com.ara.incubator.database.exposed.transaction.Transactor
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.selectAll

class Dao<ID : Comparable<ID>, ENTITY : Any, TABLE : IdTable<ID>>(
    private val table: TABLE,
    private val transactor: Transactor
) : TransactionalDao<ID, ENTITY>(transactor) {
    override fun queryFindAll(): List<ENTITY> = transactor.transaction {
        table.selectAll().mapIndexed()
    }

    override fun queryFindById(id: ID): ENTITY? {
        TODO("Not yet implemented")
    }

    override fun querySave(entity: ENTITY): ENTITY {
        TODO("Not yet implemented")
    }

    override fun queryUpdateById(id: ID, patcher: ENTITY.() -> Unit): ENTITY? {
        TODO("Not yet implemented")
    }

    override fun queryDeleteById(id: ID): ENTITY? {
        TODO("Not yet implemented")
    }
}