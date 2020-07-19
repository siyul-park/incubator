package com.ara.incubator.content

import com.ara.incubator.module.FeatureModule
import com.ara.incubator.module.Module
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.auth.Authentication
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson

object ContentNegotiationModule : Module<Application, ContentNegotiation> by FeatureModule(ContentNegotiation, {
    jackson {
        enable(SerializationFeature.INDENT_OUTPUT)
    }
})