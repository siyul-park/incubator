package com.ara.incubator.database.core.transaction

interface Transaction : AutoCloseable {
    fun commit()

    fun rollback()

    override fun close()
}