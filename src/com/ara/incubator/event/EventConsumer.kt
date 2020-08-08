package com.ara.incubator.event

interface EventConsumer<EVENT : Any> {
    fun consume(event: EVENT)
}