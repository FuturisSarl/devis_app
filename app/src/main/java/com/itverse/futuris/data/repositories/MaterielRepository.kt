package com.itverse.futuris.data.repositories

import androidx.annotation.WorkerThread
import com.itverse.futuris.data.daos.MaterielDao
import com.itverse.futuris.data.entities.Materiel
import kotlinx.coroutines.flow.Flow

class MaterielRepository(private val marielDao: MaterielDao) {

    fun allMateriels (composantId: Long): Flow<List<Materiel>> {
        return marielDao.getAllFrom(composantId)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(materiel: Materiel) {
        marielDao.insert(materiel)
    }
}