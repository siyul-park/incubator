package com.ara.incubator.database.core.dao.event

interface NewbieEntityEvent<ENTITY : Any> : EntityEvent<ENTITY> {
    val newbie: ENTITY
}