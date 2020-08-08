package com.ara.incubator

import com.ara.incubator.authentication.AuthenticationModule
import com.ara.incubator.content.ContentNegotiationModule
import com.ara.incubator.module.install
import com.ara.incubator.route.RouteModule
import com.ara.incubator.route.RoutingInitializer
import io.ktor.application.Application

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(AuthenticationModule)
    install(ContentNegotiationModule)
    install(RouteModule(RoutingInitializer))

//    DataBaseModule.install(H)
}
