package com.ara.incubator.database.core.dao.event

interface OldieEntityEvent<ENTITY : Any> : EntityEvent<ENTITY> {
    val oldie: ENTITY
}