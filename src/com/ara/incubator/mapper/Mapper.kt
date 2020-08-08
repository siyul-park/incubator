package com.ara.incubator.mapper

interface Mapper<SOURCE, TARGET> {
    fun map(source: SOURCE): TARGET
}