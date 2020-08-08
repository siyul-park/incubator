package com.ara.incubator.event

interface EventPublisher<EVENT : Any> {
    fun publish(event: EVENT)
}