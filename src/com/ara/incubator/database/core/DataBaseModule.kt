package com.ara.incubator.database.core

import com.ara.incubator.module.Module

object DataBaseModule : Module<DataBaseConfiguration, DataBaseContext> {
    override fun install(context: DataBaseConfiguration): DataBaseContext {
        val initializer = DataBaseInitializer()

        initializer.init(context)
        return initializer.context
    }
}