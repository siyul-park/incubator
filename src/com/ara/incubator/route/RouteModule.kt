package com.ara.incubator.route

import com.ara.incubator.initializer.Initializer
import com.ara.incubator.module.Module
import io.ktor.application.Application
import io.ktor.routing.Routing
import io.ktor.routing.routing

class RouteModule(private val initializer: Initializer<Routing>) : Module<Application, Routing> {
    override fun install(pipeline: Application) = with(pipeline) {
        routing { initializer.init(this) }
    }
}