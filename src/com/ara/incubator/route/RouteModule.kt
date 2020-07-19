package com.ara.incubator.route

import com.ara.incubator.module.Module
import com.ara.incubator.route.router.RootRouter
import io.ktor.application.Application
import io.ktor.routing.Routing
import io.ktor.routing.routing

object RouteModule : Module<Application, Routing>, Router {
    override fun install(pipeline: Application) = with(pipeline) {
        routing { routes(this) }
    }

    override fun routes(routing: Routing) {
        RootRouter.routes(routing)
    }
}