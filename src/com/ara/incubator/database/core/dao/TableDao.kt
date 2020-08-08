package com.ara.incubator.database.core.dao

interface TableDao<TABLE : Any> {
    suspend fun create(vararg table: TABLE): Collection<TABLE>
}