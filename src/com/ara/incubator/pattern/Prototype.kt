package com.ara.incubator.pattern

interface Prototype<T : Any> : Cloneable {
    public override fun clone(): T
}