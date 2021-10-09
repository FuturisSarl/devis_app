package com.itverse.futuris.data.repositories

import com.itverse.futuris.data.daos.GroupedElementsDao
import com.itverse.futuris.data.entities.GroupedElements
import com.itverse.futuris.data.entities.relations.GroupedElementsWithElements
import kotlinx.coroutines.flow.Flow


class GroupedElementsWithElementsRepository (private val groupedElementsDao: GroupedElementsDao){

    fun allComposantsWithElementsFrom(composantId: Long): Flow<List<GroupedElementsWithElements>> {
        return groupedElementsDao.getAllWithElementsFrom(composantId)
    }

    suspend fun allComposantsWithElementsFrom_(composantId: Long): List<GroupedElementsWithElements> {
        return groupedElementsDao.getAllWithElementsFrom_(composantId)
    }

    suspend fun insert(groupedElement: GroupedElements): Long {
        return groupedElementsDao.insert(groupedElement)
    }
}
