package com.ara.incubator.database.core.dao.event

data class EntityDeleteEvent<ENTITY : Any>(
    override val oldie: ENTITY
) : OldieEntityEvent<ENTITY>