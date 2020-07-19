package com.ara.incubator.authentication

import com.ara.incubator.module.FeatureModule
import com.ara.incubator.module.Module
import io.ktor.application.Application
import io.ktor.auth.Authentication

object AuthenticationModule : Module<Application, Authentication> by FeatureModule(Authentication)