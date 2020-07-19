package com.ara.incubator.module

import io.ktor.application.ApplicationCall
import io.ktor.util.pipeline.Pipeline

interface Module<P : Pipeline<*, ApplicationCall>, F: Any> {
    fun install(pipeline: P): F
}

fun <P : Pipeline<*, ApplicationCall>, F : Any> P.install(
        module: Module<P, F>
) = module.install(this)