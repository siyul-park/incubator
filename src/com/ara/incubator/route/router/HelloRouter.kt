package com.ara.incubator.route.router

import com.ara.incubator.handler.HelloHandler
import com.ara.incubator.handler.intercept
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Routing.hello() {
    get("/", HelloHandler.intercept())
    get("/json/jackson") {
        call.respond(mapOf("hello" to "world"))
    }
}