package com.ara.incubator.database.core.dao.event

data class EntityUpdateEvent<ENTITY : Any>(
    override val oldie: ENTITY,
    override val newbie: ENTITY
) : OldieEntityEvent<ENTITY>, NewbieEntityEvent<ENTITY>