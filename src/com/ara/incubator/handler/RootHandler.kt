package com.ara.incubator.handler

import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.util.pipeline.PipelineContext

object RootHandler: Handler {
    override suspend fun handle(context: PipelineContext<Unit, ApplicationCall>) = with(context) {
        call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
    }
}