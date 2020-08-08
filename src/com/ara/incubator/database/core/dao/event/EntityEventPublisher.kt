package com.ara.incubator.database.core.dao.event

import com.ara.incubator.event.EventPublisher

interface EntityEventPublisher<EVENT : EntityEvent<ENTITY>, ENTITY : Any> : EventPublisher<EVENT>