package com.itverse.futuris.data.repositories

import androidx.annotation.WorkerThread
import com.itverse.futuris.data.daos.ComposantDao
import com.itverse.futuris.data.daos.GroupedElementsDao
import com.itverse.futuris.data.entities.Composant
import com.itverse.futuris.data.entities.GroupedElements
import com.itverse.futuris.data.entities.relations.ComposantWithGroupedElements
import com.itverse.futuris.data.entities.relations.GroupedElementsWithElements
import kotlinx.coroutines.flow.Flow


class GroupedElementsRepository (private val groupedElementsDao: GroupedElementsDao){

    fun allProjectComposants(composantId: Long): Flow<List<GroupedElements>> {
        return groupedElementsDao.getAllFrom(composantId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(groupedElement: GroupedElements) {
        groupedElementsDao.insert(groupedElement)
    }
}
