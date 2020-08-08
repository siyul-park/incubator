package com.ara.incubator.database.exposed.transaction

import com.ara.incubator.database.core.transaction.Transaction
import org.jetbrains.exposed.sql.transactions.TransactionInterface

class Transaction(
    private val transaction: org.jetbrains.exposed.sql.Transaction
) : Transaction, TransactionInterface by transaction {
    override fun commit() = transaction.commit()

    override fun rollback() = transaction.rollback()

    override fun close() = transaction.close()
}