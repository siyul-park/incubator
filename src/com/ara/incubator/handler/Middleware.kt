package com.ara.incubator.handler

import io.ktor.application.ApplicationCall
import io.ktor.util.pipeline.PipelineContext

class Middleware(
        private val handlers: Array<out Handler>
) : Handler {
    override suspend fun handle(context: PipelineContext<Unit, ApplicationCall>) {
        handlers.forEach { it.handle(context) }
    }

    companion object {
        fun of(vararg handlers: Handler) = Middleware(handlers)
    }
}