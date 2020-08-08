package com.ara.incubator.database.core.dao

import com.ara.incubator.database.core.dao.event.EntityCreateEvent
import com.ara.incubator.database.core.dao.event.EntityDeleteEvent
import com.ara.incubator.database.core.dao.event.EntityReadEvent
import com.ara.incubator.database.core.dao.event.EntityUpdateEvent
import com.ara.incubator.event.EventPublisher
import com.ara.incubator.pattern.Prototype

open class EventuallyDao<ID : Any, ENTITY : Prototype<ENTITY>>(
    protected val dao: Dao<ID, ENTITY>,
    private val createEventPublisher: EventPublisher<EntityCreateEvent<ENTITY>>? = null,
    private val readEventPublisher: EventPublisher<EntityReadEvent<ENTITY>>? = null,
    private val updateEventPublisher: EventPublisher<EntityUpdateEvent<ENTITY>>? = null,
    private val deleteEventPublisher: EventPublisher<EntityDeleteEvent<ENTITY>>? = null
) : Dao<ID, ENTITY> {
    override suspend fun findAll(): List<ENTITY> {
        return dao.findAll().also { entities ->
            readEventPublisher?.let { publisher ->
                entities.forEach { publisher.publish(EntityReadEvent(it)) }
            }
        }
    }

    override suspend fun findById(id: ID): ENTITY? {
        return dao.findById(id)?.also { entity ->
            readEventPublisher?.publish(EntityReadEvent(entity))
        }
    }

    override suspend fun save(entity: ENTITY): ENTITY {
        return dao.save(entity).also {
            createEventPublisher?.publish(EntityCreateEvent(it))
        }
    }

    override suspend fun updateById(id: ID, patcher: ENTITY.() -> Unit): ENTITY? {
        var oldbie: ENTITY? = null

        return dao.updateById(id) {
            oldbie = this.clone()
            patcher(this)
        }?.also {
            updateEventPublisher?.publish(EntityUpdateEvent(oldbie!!, it))
        }
    }

    override suspend fun deleteById(id: ID): ENTITY? {
        return dao.deleteById(id)?.also {
            deleteEventPublisher?.publish(EntityDeleteEvent(it))
        }
    }
}