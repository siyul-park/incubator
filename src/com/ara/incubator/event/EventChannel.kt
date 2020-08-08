package com.ara.incubator.event

interface EventChannel<EVENT : Any> {
    fun push(event: EVENT)
    fun pop(): EVENT?
}