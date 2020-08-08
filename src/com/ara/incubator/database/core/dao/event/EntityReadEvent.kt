package com.ara.incubator.database.core.dao.event

data class EntityReadEvent<ENTITY : Any>(
    override val oldie: ENTITY
) : OldieEntityEvent<ENTITY>