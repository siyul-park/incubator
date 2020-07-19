package com.ara.incubator.module

import io.ktor.application.ApplicationCall
import io.ktor.application.ApplicationFeature
import io.ktor.application.install
import io.ktor.util.pipeline.Pipeline

class FeatureModule<P : Pipeline<*, ApplicationCall>, B : Any, F : Any>(
    private val feature: ApplicationFeature<P, B, F>,
    private val configure: B.() -> Unit = {}
) : Module<P, F> {
    override fun install(pipeline: P) = pipeline.install(feature, configure)
}
