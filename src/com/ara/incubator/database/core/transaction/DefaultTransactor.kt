package com.ara.incubator.database.core.transaction

class DefaultTransactor(
    private val factory: TransactionFactory
) : Transactor {
    override fun <T> transaction(statement: Transaction.() -> T): T {
        val transaction = factory.create()
        try {
            val result = statement(transaction)
            transaction.commit()
            return result
        } catch (e: Exception) {
            transaction.rollback()
            throw e
        } finally {
            transaction.rollback()
        }
    }
}
