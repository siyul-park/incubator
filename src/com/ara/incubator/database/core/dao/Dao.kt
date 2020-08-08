package com.ara.incubator.database.core.dao

interface Dao<ID : Any, ENTITY : Any> {
    suspend fun findAll(): List<ENTITY>

    suspend fun findById(id: ID): ENTITY?

    suspend fun save(entity: ENTITY): ENTITY

    suspend fun updateById(id: ID, patcher: ENTITY.() -> Unit): ENTITY?

    suspend fun deleteById(id: ID): ENTITY?
}