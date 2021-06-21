package com.itverse.futuris.data.repositories

import com.itverse.futuris.data.daos.MaterielDao
import com.itverse.futuris.data.entities.Materiel
import kotlinx.coroutines.flow.Flow

class MaterielRepository(private val marielDao: MaterielDao) {

    fun allMaterielsFrom (composantId: Long): Flow<List<Materiel>> {
        return marielDao.getAllMaterielsFrom(composantId)
    }

    fun allMaterielsFrom_ (composantId: Long): List<Materiel> {
        return marielDao.getAllMaterielsFrom_(composantId)
    }

    suspend fun insert(materiel: Materiel): Long {
        return marielDao.insert(materiel)
    }

    suspend fun increment(materielId: Long) {
        marielDao.increment(materielId)
    }

    suspend fun decrement(materielId: Long) {
        marielDao.decrement(materielId)
    }
}