package com.ara.incubator.database.core.transaction

interface TransactionFactory {
    fun create(): Transaction
}