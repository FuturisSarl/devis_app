package com.itverse.futuris.data.repositories

import androidx.annotation.WorkerThread
import com.itverse.futuris.data.daos.ElementsDao
import com.itverse.futuris.data.daos.GroupedElementsDao
import com.itverse.futuris.data.entities.Element
import com.itverse.futuris.data.entities.GroupedElements
import com.itverse.futuris.data.entities.relations.ComposantWithGroupedElements
import kotlinx.coroutines.flow.Flow


class ElementRepository (private val elementsDao: ElementsDao){

    // TODO: Do we need this function?
    //fun allElementsFrom(groupedElement: Long): Flow<List<ComposantWithGroupedElements>> {
    //    return elementsDao.getAllFrom(groupedElement)
    //}

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(element: Element) {
        elementsDao.insert(element)
    }
}
