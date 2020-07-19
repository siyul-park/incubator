package com.ara.incubator.route

import io.ktor.routing.Routing

interface Router {
    fun routes(routing: Routing)
}