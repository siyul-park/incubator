package com.ara.incubator.database.core.dao

import com.ara.incubator.database.core.transaction.Transactor

abstract class TransactionalDao<ID : Any, ENTITY : Any>(
    private val transactor: Transactor
) : Dao<ID, ENTITY> {
    override suspend fun findAll(): List<ENTITY> = transactor.transaction {
        queryFindAll()
    }

    protected abstract fun queryFindAll(): List<ENTITY>

    override suspend fun findById(id: ID): ENTITY? = transactor.transaction {
        queryFindById(id)
    }

    protected abstract fun queryFindById(id: ID): ENTITY?

    override suspend fun save(entity: ENTITY): ENTITY = transactor.transaction {
        querySave(entity)
    }

    protected abstract fun querySave(entity: ENTITY): ENTITY

    override suspend fun updateById(id: ID, patcher: ENTITY.() -> Unit): ENTITY? = transactor.transaction {
        queryUpdateById(id, patcher)
    }

    protected abstract fun queryUpdateById(id: ID, patcher: ENTITY.() -> Unit): ENTITY?

    override suspend fun deleteById(id: ID): ENTITY? = transactor.transaction {
        queryDeleteById(id)
    }

    protected abstract fun queryDeleteById(id: ID): ENTITY?
}