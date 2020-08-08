package com.ara.incubator.module

interface Module<C : Any, F : Any> {
    fun install(context: C): F
}

fun <C : Any, F : Any> C.install(
    module: Module<C, F>
) = module.install(this)