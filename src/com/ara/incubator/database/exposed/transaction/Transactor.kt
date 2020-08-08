package com.ara.incubator.database.exposed.transaction

import com.ara.incubator.database.core.transaction.Transaction
import com.ara.incubator.database.core.transaction.Transactor
import org.jetbrains.exposed.sql.Database

class Transactor(
    private val db: Database? = null
) : Transactor {
    override fun <T> transaction(statement: Transaction.() -> T): T {
        return org.jetbrains.exposed.sql.transactions.transaction(db) {
            val transaction = Transaction(this)
            statement(transaction)
        }
    }
}