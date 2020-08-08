package com.ara.incubator.database.core.transaction

interface Transactor {
    fun <T> transaction(statement: Transaction.() -> T): T
}
