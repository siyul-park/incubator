package com.ara.incubator.database.core.dao.event

data class EntityCreateEvent<ENTITY : Any>(
    override val newbie: ENTITY
) : NewbieEntityEvent<ENTITY>