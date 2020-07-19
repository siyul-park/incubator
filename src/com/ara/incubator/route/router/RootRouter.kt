package com.ara.incubator.route.router

import com.ara.incubator.handler.RootHandler
import com.ara.incubator.handler.intercept
import com.ara.incubator.route.Router
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get

object RootRouter : Router {
    override fun routes(routing: Routing): Unit = with(routing) {
        get("/", RootHandler.intercept())
        get("/json/jackson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}