package com.ara.incubator.handler

import io.ktor.application.ApplicationCall
import io.ktor.util.pipeline.PipelineContext
import io.ktor.util.pipeline.PipelineInterceptor

interface Handler {
    suspend fun handle(context: PipelineContext<Unit, ApplicationCall>)
}

fun Handler.intercept(): PipelineInterceptor<Unit, ApplicationCall> {
    val me = this
    return { me.handle(this) }
}