package com.itverse.futuris.data.repositories

import androidx.annotation.WorkerThread
import com.itverse.futuris.data.daos.MaterielDao
import com.itverse.futuris.data.entities.Materiel
import kotlinx.coroutines.flow.Flow

class MaterielRepository(private val marielDao: MaterielDao) {

    fun allMateriels (composantId: Long): Flow<List<Materiel>> {
        return marielDao.getAllFrom(composantId)
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