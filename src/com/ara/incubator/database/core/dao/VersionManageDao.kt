package com.ara.incubator.database.core.dao

import com.ara.incubator.database.core.entity.Versional

open class VersionManageDao<ID : Any, ENTITY : Versional>(
    protected val dao: Dao<ID, ENTITY>
) : Dao<ID, ENTITY> by dao {
    override suspend fun save(entity: ENTITY): ENTITY {
        entity.version += 1
        return dao.save(entity)
    }

    override suspend fun updateById(id: ID, patcher: ENTITY.() -> Unit): ENTITY? {
        return dao.updateById(id) {
            patcher(this)
            this.version += 1
        }
    }
}