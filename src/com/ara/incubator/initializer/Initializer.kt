package com.ara.incubator.initializer

interface Initializer<T : Any> {
    fun init(context: T)
}