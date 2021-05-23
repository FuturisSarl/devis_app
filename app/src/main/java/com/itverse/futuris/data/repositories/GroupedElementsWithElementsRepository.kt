package com.itverse.futuris.data.repositories

import com.itverse.futuris.data.daos.GroupedElementsDao
import com.itverse.futuris.data.entities.relations.GroupedElementsWithElements
import kotlinx.coroutines.flow.Flow


class GroupedElementsWithElementsRepository (private val groupedElementsDao: GroupedElementsDao){

    fun allComposantsWithElementsFrom(composantId: Long): Flow<List<GroupedElementsWithElements>> {
        return groupedElementsDao.getAllWithElementsFrom(composantId)
    }
}
