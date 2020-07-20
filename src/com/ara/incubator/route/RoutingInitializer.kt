package com.ara.incubator.route

import com.ara.incubator.initializer.Initializer
import com.ara.incubator.route.router.hello
import io.ktor.routing.Routing

object RoutingInitializer : Initializer<Routing> {
    override fun init(context: Routing) {
        context.hello()
    }
}